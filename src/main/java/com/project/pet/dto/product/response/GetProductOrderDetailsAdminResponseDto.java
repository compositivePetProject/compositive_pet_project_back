package com.project.pet.dto.product.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetProductOrderDetailsAdminResponseDto {
    private int productOrderDetailId;
    private String productNameKor;
    private String productSizeCategoryName;
    private int productOrderCount;
    private String name;
    private String productOrderAddress;
    private String productOrderDetailAddress;
}
