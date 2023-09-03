package com.mlt.api.apioperations.domain.operation;

import com.mlt.api.apioperations.domain.dto.request.SellShoppingCartRequest;
import com.mlt.api.apioperations.model.OperationModel;
import com.mlt.api.apioperations.model.OperationStatusModel;
import com.mlt.api.apioperations.model.OperationTransitionModel;
import com.mlt.api.apioperations.repository.OperationRepository;
import com.mlt.api.apioperations.repository.OperationStatusRepository;
import com.mlt.api.apioperations.statemachine.enums.OperationEvent;
import com.mlt.api.apioperations.statemachine.enums.OperationState;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Builder
public class Operation {

    private final StateMachine<OperationState, OperationEvent> stateMachine;
    private final OperationModel operationModel;
    private final OperationRepository operationRepository;
    private final OperationStatusRepository operationStatusRepository;

    public void sellShoppingCart(SellShoppingCartRequest request) {
        operationModel.setShoppingCartCode(request.getShoppingCartCode());
    }

    public void operate() {
        stateMachine.startReactively().subscribe();
        stateMachine.sendEvent(Mono.just(MessageBuilder.withPayload(OperationEvent.INIT)
                                                       .setHeader("OPERATION", this)
                                                       .build())).subscribe();
    }

    public OperationModel getModel() {
        return this.operationModel;
    }

    public void changeState(OperationState to) {
        LocalDateTime now = LocalDateTime.now();
        OperationStatusModel toStatus = operationStatusRepository.findByDescriptionIgnoreCase(to.name())
                                                                 .orElseThrow(() -> new IllegalArgumentException(to.name()));
        OperationTransitionModel transition = OperationTransitionModel.builder()
                                                                      .fromStatus(operationModel.getOperationStatus())
                                                                      .toStatus(toStatus)
                                                                      .operation(operationModel)
                                                                      .createdAt(now)
                                                                      .build();
        operationModel.setUpdatedAt(now);
        operationModel.addTransition(transition);
        operationModel.setOperationStatus(toStatus);

        operationRepository.save(operationModel);
    }

}
