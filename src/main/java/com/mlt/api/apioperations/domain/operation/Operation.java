package com.mlt.api.apioperations.domain.operation;

import com.mlt.api.apioperations.model.OperationModel;
import com.mlt.api.apioperations.statemachine.enums.OperationEvent;
import com.mlt.api.apioperations.statemachine.enums.OperationState;
import lombok.Getter;
import lombok.Setter;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Operation {

    private final StateMachine<OperationState, OperationEvent> stateMachine;
    private final OperationModel operationModel;
    private List<OperationTransition> states;

    private Operation(StateMachine<OperationState, OperationEvent> stateMachine, OperationModel operationModel) {
        this.stateMachine = stateMachine;
        this.operationModel = operationModel;
        this.states = new ArrayList<>();
    }

    public void operate() {
        stateMachine.startReactively().subscribe();
        stateMachine.sendEvent(Mono.just(MessageBuilder.withPayload(OperationEvent.VALIDATE)
                                                       .setHeader("OPERATION", this)
                                                       .build())).subscribe();
    }

    public OperationModel getOperation() {
        return this.operationModel;
    }

    public void addState(OperationTransition state) {
        this.states.add(state);
    }


    public static Builder builder(StateMachine<OperationState, OperationEvent> stateMachine) {

        return new Builder(stateMachine);
    }

    public static Builder builder(
            StateMachine<OperationState, OperationEvent> stateMachine,
            OperationModel operationModel
    ) {
        return new Builder(stateMachine, operationModel);
    }

    public static class Builder {
        private final StateMachine<OperationState, OperationEvent> stateMachine;
        private final OperationModel operationModel;


        public Builder(StateMachine<OperationState, OperationEvent> stateMachine) {
            this.stateMachine = stateMachine;
            this.operationModel = OperationModel.builder().build();
        }

        public Builder(StateMachine<OperationState, OperationEvent> stateMachine, OperationModel operationModel) {
            this.stateMachine = stateMachine;
            this.operationModel = operationModel;
        }

        public Operation build() {
            return new Operation(stateMachine, operationModel);
        }
    }

}
