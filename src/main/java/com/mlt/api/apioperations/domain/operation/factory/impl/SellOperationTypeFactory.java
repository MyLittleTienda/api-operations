package com.mlt.api.apioperations.domain.operation.factory.impl;

import com.mlt.api.apioperations.domain.operation.Operation;
import com.mlt.api.apioperations.domain.operation.factory.OperationFactory;
import com.mlt.api.apioperations.enums.OperationTypeEnum;
import com.mlt.api.apioperations.statemachine.factory.OperationStateMachineFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SellOperationTypeFactory implements OperationFactory {

    private final OperationStateMachineFactory stateMachineFactory;

    @Override
    public Operation create(OperationTypeEnum type) {
        return Operation.builder(stateMachineFactory.create(type)).build();
    }
}
