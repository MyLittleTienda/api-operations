package com.mlt.api.apioperations.statemachine.factory.impl;

import com.mlt.api.apioperations.enums.OperationTypeEnum;
import com.mlt.api.apioperations.statemachine.config.impl.SellOperationTypeStateMachineConfig;
import com.mlt.api.apioperations.statemachine.enums.OperationEvent;
import com.mlt.api.apioperations.statemachine.enums.OperationState;
import com.mlt.api.apioperations.statemachine.factory.OperationStateMachineFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OperationStateMachineFactoryImpl implements OperationStateMachineFactory {

    private final SellOperationTypeStateMachineConfig sellOperationTypeStateMachineConfig;

    @Override
    public StateMachine<OperationState, OperationEvent> create(OperationTypeEnum type) {
        try {
            return switch (type) {
                case SELL -> sellOperationTypeStateMachineConfig.create();
                default -> throw new RuntimeException("Operation type not supported");
            };
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
