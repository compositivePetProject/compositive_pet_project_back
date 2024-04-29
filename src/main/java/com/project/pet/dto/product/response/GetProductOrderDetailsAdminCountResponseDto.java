package com.project.pet.dto.product.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetProductOrderDetailsAdminCountResponseDto {
    private int maxPageNumber;
    private int totalCount;
}
