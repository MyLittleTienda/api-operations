package com.mlt.api.apioperations.domain.dto.request;

import com.mlt.api.common.domain.request.MltRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShoppingCartProduct extends MltRequest {

    private String productCode;
    private Integer quantity;
    private BigDecimal price;

}
