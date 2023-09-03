package com.mlt.api.apioperations.statemachine.factory;

import com.mlt.api.apioperations.enums.OperationTypeEnum;
import com.mlt.api.apioperations.statemachine.enums.OperationEvent;
import com.mlt.api.apioperations.statemachine.enums.OperationState;
import org.springframework.statemachine.StateMachine;

public interface OperationStateMachineFactory {

    StateMachine<OperationState, OperationEvent> create(OperationTypeEnum type);

}
