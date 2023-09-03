package com.mlt.api.apioperations.domain.operation;

import com.mlt.api.apioperations.statemachine.enums.OperationState;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OperationTransition {

    private OperationState from;
    private OperationState to;


}
