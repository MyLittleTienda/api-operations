package com.mlt.api.apioperations.statemachine.config;

import com.mlt.api.apioperations.statemachine.enums.OperationEvent;
import com.mlt.api.apioperations.statemachine.enums.OperationState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.guard.Guard;

@Slf4j
public abstract class SimpleStateMachineConfiguration {

    public StateMachine<OperationState, OperationEvent> create() throws Exception {
        StateMachineBuilder.Builder<OperationState, OperationEvent> builder = StateMachineBuilder.builder();
        configure(builder.configureStates());
        configure(builder.configureTransitions());
        configure(builder.configureConfiguration());

        return builder.build();
    }

    protected Action<OperationState, OperationEvent> actionPendingToValidating() {
        return (ctx) -> log.info("Without Implementation");
    }

    protected Guard<OperationState, OperationEvent> guardPendingToValidating() {
        return (ctx) -> {
            log.info("guard Pending to Validating not implemented, returning true");
            return true;
        };
    }

    protected Action<OperationState, OperationEvent> actionValidatingToInProcess() {
        return (ctx) -> log.info("Without Implementation");
    }

    protected Guard<OperationState, OperationEvent> guardValidatingToInProcess() {
        return (ctx) -> {
            log.info("guard Validating to In Process not implemented, returning true");
            return true;
        };
    }

    protected Action<OperationState, OperationEvent> actionValidatingToRejected() {
        return (ctx) -> log.info("Without Implementation");
    }

    protected Guard<OperationState, OperationEvent> guardValidatingToRejected() {
        return (ctx) -> {
            log.info("guard Validating to In Process not implemented, returning true");
            return true;
        };
    }

    protected Action<OperationState, OperationEvent> actionInProcessToApproved() {
        return (ctx) -> log.info("Without Implementation");
    }

    protected Guard<OperationState, OperationEvent> guardInProcessToApproved() {
        return (ctx) -> {
            log.info("guard Validating to In Process not implemented, returning true");
            return true;
        };
    }

    protected Action<OperationState, OperationEvent> actionInProcessToCanceled() {
        return (ctx) -> log.info("Without Implementation");
    }

    protected Guard<OperationState, OperationEvent> guardInProcessToCanceled() {
        return (ctx) -> {
            log.info("guard Validating to In Process not implemented, returning true");
            return true;
        };
    }

    private void configure(StateMachineTransitionConfigurer<OperationState, OperationEvent> transitions) throws
            Exception {
        transitions.withExternal()
                   .source(OperationState.PENDING)
                   .target(OperationState.VALIDATING)
                   .event(OperationEvent.INIT)
                   .action(actionPendingToValidating())
                   .guard(guardPendingToValidating())
                   .and()
                   .withExternal()
                   .source(OperationState.VALIDATING)
                   .target(OperationState.IN_PROCESS)
                   .action(actionValidatingToInProcess())
                   .guard(guardValidatingToInProcess())
                   .and()
                   .withExternal()
                   .source(OperationState.VALIDATING)
                   .target(OperationState.REJECTED)
                   .action(actionValidatingToRejected())
                   .guard(guardValidatingToRejected())
                   .and()
                   .withExternal()
                   .source(OperationState.IN_PROCESS)
                   .target(OperationState.APPROVED)
                   .action(actionInProcessToApproved())
                   .guard(guardInProcessToApproved())
                   .and()
                   .withExternal()
                   .source(OperationState.IN_PROCESS)
                   .target(OperationState.CANCELED)
                   .action(actionInProcessToCanceled())
                   .guard(guardInProcessToCanceled());
    }

    private void configure(StateMachineStateConfigurer<OperationState, OperationEvent> states) throws Exception {
        states.withStates()
              .initial(OperationState.PENDING)
              .end(OperationState.REJECTED)
              .end(OperationState.CANCELED)
              .end(OperationState.APPROVED)
              .state(OperationState.VALIDATING)
              .state(OperationState.IN_PROCESS);
    }

    private void configure(StateMachineConfigurationConfigurer<OperationState, OperationEvent> config) throws
            Exception {
        config.withConfiguration()
              .autoStartup(false);
    }

}
