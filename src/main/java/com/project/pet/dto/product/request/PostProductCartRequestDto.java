package com.project.pet.dto.product.request;

import com.project.pet.entity.product.ProductCart;
import com.project.pet.entity.product.ProductComment;
import com.project.pet.entity.product.ProductOrder;
import lombok.Data;

@Data
public class PostProductCartRequestDto {
    private int productId;
    private int productSizeCategoryId;
    private int productCartCount;

    public ProductCart toEntity(int userId) {
        return ProductCart.builder()
                .productId(productId)
                .userId(userId)
                .productSizeCategoryId(productSizeCategoryId)
                .productCartCount(productCartCount)
                .build();
    }

}
