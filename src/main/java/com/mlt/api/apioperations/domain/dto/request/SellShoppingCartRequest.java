package com.mlt.api.apioperations.domain.dto.request;

import com.mlt.api.common.domain.request.MltRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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

    @NotBlank
    private String shoppingCartCode;
    @NotBlank
    private String username;
    @NotBlank
    private String paymentMethod;
    @NotEmpty
    @Valid
    private List<ShoppingCartProduct> products;

}
