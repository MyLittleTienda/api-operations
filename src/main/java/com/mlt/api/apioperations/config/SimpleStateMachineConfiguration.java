package com.mlt.api.apioperations.config;

import com.mlt.api.apioperations.statemachine.enums.OperationEvent;
import com.mlt.api.apioperations.statemachine.enums.OperationState;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.Set;

@Configuration
@EnableStateMachine
public class SimpleStateMachineConfiguration extends StateMachineConfigurerAdapter<OperationState, OperationEvent> {

    @Override
    public void configure(StateMachineStateConfigurer<OperationState, OperationEvent> states) throws Exception {
        states.withStates()
              .initial(OperationState.PENDING)
              .end(OperationState.REJECTED)
              .end(OperationState.CANCELED)
              .end(OperationState.APPROVED)
              .states(Set.of(OperationState.IN_PROCESS));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<OperationState, OperationEvent> transitions) throws
            Exception {
        transitions.withExternal()
                   .source(OperationState.PENDING)
                   .target(OperationState.IN_PROCESS)
                   .and()
                   .withExternal()
                   .source(OperationState.PENDING)
                   .target(OperationState.REJECTED)
                   .and()
                   .withExternal()
                   .source(OperationState.IN_PROCESS)
                   .target(OperationState.APPROVED)
                   .and()
                   .withExternal()
                   .source(OperationState.IN_PROCESS)
                   .target(OperationState.CANCELED);
    }
}
