package com.project.pet.dto.product.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetProductOrdersResponseDto {
    private int productOrderId;
    private int userId;
    private int productId;
    private String productOrderAddress;
    private String productDetailOrderAddress;
    private int productSizeCategoryId;
    private int productOrderCount;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
