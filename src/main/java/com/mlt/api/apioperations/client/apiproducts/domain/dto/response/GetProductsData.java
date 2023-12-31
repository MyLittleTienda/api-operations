package com.mlt.api.apioperations.client.apiproducts.domain.dto.response;

import com.mlt.api.apioperations.client.apiproducts.domain.dto.data.ProductDTO;
import com.mlt.api.common.domain.response.MltPagedData;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class GetProductsData extends MltPagedData {


    private List<ProductDTO> products;

    @Builder
    public GetProductsData(
            Long totalElements,
            Integer totalPages,
            Integer size,
            Integer page,
            List<ProductDTO> products
    ) {
        super(totalElements, totalPages, size, page);
        this.products = products;
    }
}
