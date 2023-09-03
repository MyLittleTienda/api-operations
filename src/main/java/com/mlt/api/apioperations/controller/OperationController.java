package com.mlt.api.apioperations.controller;

import com.mlt.api.apioperations.domain.dto.request.SellShoppingCartRequest;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/operations")
@Validated
public interface OperationController {

    @PostMapping
    void sellShoppingCart(@RequestBody @Valid SellShoppingCartRequest request);

}
