package com.project.pet.dto.product.request;

import com.project.pet.entity.product.ProductOrder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostProductOrderRequestDto {
    private int userId;
    private int productId;
    private String productOrderAddress;
    private String productOrderDetailAddress;
    private int productSizeCategoryId;
    private int productOrderCount;

    public ProductOrder toEntity() {
        return ProductOrder.builder()
                .userId(userId)
                .productId(productId)
                .productOrderAddress(productOrderAddress)
                .productOrderDetailAddress(productOrderDetailAddress)
                .productSizeCategoryId(productSizeCategoryId)
                .productOrderCount(productOrderCount)
                .build();
    }
}
