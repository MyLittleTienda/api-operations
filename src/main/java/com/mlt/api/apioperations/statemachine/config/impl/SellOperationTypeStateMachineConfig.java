package com.mlt.api.apioperations.statemachine.config.impl;

import java.util.Objects;

import org.springframework.context.annotation.Scope;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.guard.Guard;
import org.springframework.stereotype.Component;

import com.mlt.api.apioperations.domain.operation.Operation;
import com.mlt.api.apioperations.statemachine.config.SimpleStateMachineConfiguration;
import com.mlt.api.apioperations.statemachine.enums.OperationEvent;
import com.mlt.api.apioperations.statemachine.enums.OperationState;

import lombok.RequiredArgsConstructor;

@Component
@Scope("prototype")
@RequiredArgsConstructor
public class SellOperationTypeStateMachineConfig extends SimpleStateMachineConfiguration {

    private static final String OPERATION = "OPERATION";

    @Override
    protected Action<OperationState, OperationEvent> actionPendingToValidating() {
        return ctx -> {
            Operation operation = ctx.getMessage().getHeaders().get(OPERATION, Operation.class);
            changeOperationState(operation, ctx.getTransition().getTarget().getId());
        };
    }

    @Override
    protected Guard<OperationState, OperationEvent> guardPendingToValidating() {
        return ctx -> true;
    }

    @Override
    protected Action<OperationState, OperationEvent> actionValidatingToInProcess() {
        return ctx -> {
            Operation operation = ctx.getMessage().getHeaders().get(OPERATION, Operation.class);
            changeOperationState(operation, ctx.getTransition().getTarget().getId());
        };
    }

    @Override
    protected Guard<OperationState, OperationEvent> guardValidatingToInProcess() {
        return ctx -> true;
    }

    @Override
    protected Action<OperationState, OperationEvent> actionValidatingToRejected() {
        return ctx -> {
            Operation operation = ctx.getMessage().getHeaders().get(OPERATION, Operation.class);
            changeOperationState(operation, ctx.getTransition().getTarget().getId());
        };
    }

    @Override
    protected Guard<OperationState, OperationEvent> guardValidatingToRejected() {
        return ctx -> false;
    }

    @Override
    protected Action<OperationState, OperationEvent> actionInProcessToApproved() {
        return ctx -> {
            Operation operation = ctx.getMessage().getHeaders().get(OPERATION, Operation.class);
            changeOperationState(operation, ctx.getTransition().getTarget().getId());
        };
    }

    @Override
    protected Guard<OperationState, OperationEvent> guardInProcessToApproved() {
        return ctx -> true;
    }

    @Override
    protected Action<OperationState, OperationEvent> actionInProcessToCanceled() {
        return ctx -> {
            Operation operation = ctx.getMessage().getHeaders().get(OPERATION, Operation.class);
            changeOperationState(operation, ctx.getTransition().getTarget().getId());
        };
    }

    @Override
    protected Guard<OperationState, OperationEvent> guardInProcessToCanceled() {
        return ctx -> false;
    }

    private void changeOperationState(Operation operation, OperationState state) {
        if (Objects.nonNull(operation)) {
            operation.changeState(state);
        }
    }

}
