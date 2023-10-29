package com.mlt.api.apioperations.client.apiproducts;

import com.mlt.api.apioperations.client.apiproducts.domain.dto.response.GetProductsData;
import com.mlt.api.common.domain.response.MltResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "products", url = "https://api-products-dot-mlt-api-products.rj.r.appspot.com")
public interface ApiProductsClient {

    @GetMapping("/api/v1/products")
    MltResponse<GetProductsData> getProducts(@RequestParam List<String> ids);

}
