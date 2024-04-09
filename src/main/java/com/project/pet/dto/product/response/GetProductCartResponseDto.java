package com.project.pet.dto.product.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetProductCartResponseDto {
    private int productCartId;
    private int userId;
    private int productId;
    private int productSizeCategoryId;
    private int productCartCount;
}
