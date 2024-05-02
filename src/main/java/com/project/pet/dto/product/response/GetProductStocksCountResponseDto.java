package com.project.pet.dto.product.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetProductStocksCountResponseDto {
    private int totalCount;
    private int maxPageNumber;
}