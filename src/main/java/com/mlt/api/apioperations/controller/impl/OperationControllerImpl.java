package com.mlt.api.apioperations.controller.impl;

import com.mlt.api.apioperations.controller.OperationController;
import com.mlt.api.apioperations.domain.dto.request.SellShoppingCartRequest;
import com.mlt.api.apioperations.service.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OperationControllerImpl implements OperationController {

    private final OperationService operationService;

    @Override
    public void sellShoppingCart(SellShoppingCartRequest request) {
        operationService.sellShoppingCart(request); 
    }

}
