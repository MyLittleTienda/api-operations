package com.mlt.api.apioperations.domain.operation.factory.impl;

import com.mlt.api.apioperations.domain.operation.Operation;
import com.mlt.api.apioperations.domain.operation.factory.OperationFactory;
import com.mlt.api.apioperations.enums.OperationTypeEnum;
import com.mlt.api.apioperations.model.OperationModel;
import com.mlt.api.apioperations.model.OperationStatusModel;
import com.mlt.api.apioperations.model.OperationTypeModel;
import com.mlt.api.apioperations.repository.OperationRepository;
import com.mlt.api.apioperations.repository.OperationStatusRepository;
import com.mlt.api.apioperations.repository.OperationTypeRepository;
import com.mlt.api.apioperations.statemachine.enums.OperationState;
import com.mlt.api.apioperations.statemachine.factory.OperationStateMachineFactory;
import com.mlt.api.common.handler.error.exception.validation.IdsNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SellOperationTypeFactory implements OperationFactory {

    private final OperationStateMachineFactory stateMachineFactory;
    private final OperationRepository operationRepository;
    private final OperationStatusRepository operationStatusRepository;
    private final OperationTypeRepository operationTypeRepository;

    @Override
    public Operation create(OperationTypeEnum type) {
        return Operation.builder()
                        .stateMachine(stateMachineFactory.create(type))
                        .operationStatusRepository(operationStatusRepository)
                        .operationRepository(operationRepository)
                        .operationModel(buildOperationModel(type, null))
                        .build();
    }

    @Override
    public Operation create(OperationTypeEnum type, OperationModel operationFor) {
        return Operation.builder()
                        .stateMachine(stateMachineFactory.create(type))
                        .operationStatusRepository(operationStatusRepository)
                        .operationRepository(operationRepository)
                        .operationModel(buildOperationModel(type, operationFor))
                        .build();
    }

    @Override
    public Operation create(OperationTypeEnum type, Long operationId) {
        OperationModel operationModel = operationRepository.findById(operationId)
                                                           .orElseThrow(() -> IdsNotFoundException.builder(
                                                                   "operationId",
                                                                   List.of(operationId.toString())
                                                           ).build());
        return create(type, operationModel);
    }

    private OperationModel buildOperationModel(OperationTypeEnum typeEnum, OperationModel operationFor) {
        OperationTypeModel type = operationTypeRepository.findByDescriptionIgnoreCase(typeEnum.name())
                                                         .orElseThrow(() -> new IllegalArgumentException(typeEnum.name()));
        OperationStatusModel status = operationStatusRepository.findByDescriptionIgnoreCase(OperationState.PENDING.name())
                                                               .orElseThrow(() -> new IllegalArgumentException(
                                                                       OperationState.PENDING.name()));
        return OperationModel.builder()
                             .operationType(type)
                             .operationStatus(status)
                             .createdAt(LocalDateTime.now())
                             .updatedAt(LocalDateTime.now())
                             .transitions(new ArrayList<>())
                             .details(new ArrayList<>())
                             .operationFor(operationFor)
                             .build();
    }
}
