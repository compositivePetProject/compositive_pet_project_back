package com.project.pet.dto.product.request;

import com.project.pet.entity.product.ProductFavorite;
import lombok.Data;

@Data
public class PostProductFavoriteRequestDto {

    private int productId;

    public ProductFavorite toEntity(int userId) {
        return ProductFavorite.builder()
                .productId(productId)
                .userId(userId)
                .build();
    }

}
