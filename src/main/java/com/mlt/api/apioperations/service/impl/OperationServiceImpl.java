package com.mlt.api.apioperations.service.impl;

import com.mlt.api.apioperations.domain.dto.request.SellShoppingCartRequest;
import com.mlt.api.apioperations.domain.operation.Operation;
import com.mlt.api.apioperations.domain.operation.factory.OperationFactory;
import com.mlt.api.apioperations.enums.OperationTypeEnum;
import com.mlt.api.apioperations.service.OperationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OperationServiceImpl implements OperationService {

    private final OperationFactory operationFactory;

    @Override
    public void sellShoppingCart(SellShoppingCartRequest request) {
        Operation operation = operationFactory.create(OperationTypeEnum.SALE);
        operation.operate();
        log.info(operation.toString());
    }
}
