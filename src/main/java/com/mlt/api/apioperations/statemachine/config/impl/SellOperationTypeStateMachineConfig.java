package com.mlt.api.apioperations.statemachine.config.impl;

import com.mlt.api.apioperations.domain.operation.Operation;
import com.mlt.api.apioperations.domain.operation.OperationTransition;
import com.mlt.api.apioperations.statemachine.config.SimpleStateMachineConfiguration;
import com.mlt.api.apioperations.statemachine.enums.OperationEvent;
import com.mlt.api.apioperations.statemachine.enums.OperationState;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.guard.Guard;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Scope("prototype")
@Slf4j
@RequiredArgsConstructor
public class SellOperationTypeStateMachineConfig extends SimpleStateMachineConfiguration {

    @Override
    protected Action<OperationState, OperationEvent> actionPendingToValidating() {
        return (ctx) ->
        {
            Operation operation = ctx.getMessage().getHeaders().get("OPERATION", Operation.class);
            if (Objects.nonNull(operation)) {
                operation.addState(OperationTransition.builder()
                                                      .from(ctx.getTransition().getSource().getId())
                                                      .to(ctx.getTarget().getId())
                                                      .build());
            }
            log.info(ctx.getStateMachine().getState().toString());
        };
    }

    @Override
    protected Guard<OperationState, OperationEvent> guardPendingToValidating() {
        return (ctx) -> true;
    }

    @Override
    protected Action<OperationState, OperationEvent> actionValidatingToInProcess() {
        return (ctx) ->
        {
            Operation operation = ctx.getMessage().getHeaders().get("OPERATION", Operation.class);
            if (Objects.nonNull(operation)) {
                operation.addState(OperationTransition.builder()
                                                      .from(ctx.getTransition().getSource().getId())
                                                      .to(ctx.getTarget().getId())
                                                      .build());
            }
            log.info(ctx.getStateMachine().getState().toString());
        };
    }

    @Override
    protected Guard<OperationState, OperationEvent> guardValidatingToInProcess() {
        return (ctx) -> true;
    }

    @Override
    protected Action<OperationState, OperationEvent> actionValidatingToRejected() {
        return (ctx) ->
        {
            Operation operation = ctx.getMessage().getHeaders().get("OPERATION", Operation.class);
            if (Objects.nonNull(operation)) {
                operation.addState(OperationTransition.builder()
                                                      .from(ctx.getTransition().getSource().getId())
                                                      .to(ctx.getTarget().getId())
                                                      .build());
            }
            log.info(ctx.getStateMachine().getState().toString());
        };
    }

    @Override
    protected Guard<OperationState, OperationEvent> guardValidatingToRejected() {
        return (ctx) -> false;
    }

    @Override
    protected Action<OperationState, OperationEvent> actionInProcessToApproved() {
        return (ctx) ->
        {
            Operation operation = ctx.getMessage().getHeaders().get("OPERATION", Operation.class);
            if (Objects.nonNull(operation)) {
                operation.addState(OperationTransition.builder()
                                                      .from(ctx.getTransition().getSource().getId())
                                                      .to(ctx.getTarget().getId())
                                                      .build());
            }
            log.info(ctx.getStateMachine().getState().toString());
        };
    }

    @Override
    protected Guard<OperationState, OperationEvent> guardInProcessToApproved() {
        return (ctx) -> true;
    }

    @Override
    protected Action<OperationState, OperationEvent> actionInProcessToCanceled() {
        return (ctx) ->
        {
            Operation operation = ctx.getMessage().getHeaders().get("OPERATION", Operation.class);
            if (Objects.nonNull(operation)) {
                operation.addState(OperationTransition.builder()
                                                      .from(ctx.getTransition().getSource().getId())
                                                      .to(ctx.getTarget().getId())
                                                      .build());
            }
            log.info(ctx.getStateMachine().getState().toString());
        };
    }

    @Override
    protected Guard<OperationState, OperationEvent> guardInProcessToCanceled() {
        return (ctx) -> false;
    }

}
