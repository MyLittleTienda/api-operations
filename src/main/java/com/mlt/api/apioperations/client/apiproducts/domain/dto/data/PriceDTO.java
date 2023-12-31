package com.mlt.api.apioperations.client.apiproducts.domain.dto.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mlt.api.common.domain.response.MltData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PriceDTO extends MltData {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    private Double value;

}
