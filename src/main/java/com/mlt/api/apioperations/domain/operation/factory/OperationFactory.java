package com.mlt.api.apioperations.domain.operation.factory;

import com.mlt.api.apioperations.domain.operation.Operation;
import com.mlt.api.apioperations.enums.OperationTypeEnum;
import com.mlt.api.apioperations.model.OperationModel;

public interface OperationFactory {
    Operation create(OperationTypeEnum type);

    Operation create(OperationTypeEnum type, OperationModel operationModel);

    Operation create(OperationTypeEnum type, Long operationId);

}
