package com.mlt.api.apioperations.domain.dto.request;

import com.mlt.api.common.domain.request.MltRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SellShoppingCartRequest extends MltRequest {

    private String shoppingCartCode;
    private String username;
    private String paymentMethod;
    private List<ShoppingCartProduct> products;

}
