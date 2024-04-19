package com.project.pet.entity.product;

import com.project.pet.dto.product.response.GetProductCartResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductCart {
    private int productCartId;
    private int userId;
    private int productId;
    private int productSizeCategoryId;
    private int productCartCount;

    private ProductOrder productOrder;
    public GetProductCartResponseDto toGetProductCartResponseDto() {
        return GetProductCartResponseDto.builder()
                .productCartId(productCartId)
                .userId(userId)
                .productId(productId)
                .productSizeCategoryId(productSizeCategoryId)
                .productCartCount(productCartCount)
                .productOrderId(productOrder.getProductOrderId())
                .productOrderAddress(productOrder.getProductOrderAddress())
                .productOrderDetailAddress(productOrder.getProductOrderDetailAddress())
                .productOrderCount(productOrder.getProductOrderCount())
                .build();
    }
}
