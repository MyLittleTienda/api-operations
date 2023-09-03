package com.mlt.api.apioperations.domain.operation.factory;

import com.mlt.api.apioperations.domain.operation.Operation;
import com.mlt.api.apioperations.enums.OperationTypeEnum;

public interface OperationFactory {
    Operation create(OperationTypeEnum type);

}
