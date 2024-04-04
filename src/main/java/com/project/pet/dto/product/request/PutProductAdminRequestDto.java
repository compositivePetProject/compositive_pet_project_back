package com.project.pet.dto.product.request;

import com.project.pet.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PutProductAdminRequestDto {
    private int productId;
    private int userId;
    private String productNameKor;
    private int productPrice;
    private String productImageUrl;
    private int productCategoryId;
    private int productAnimalCategoryId;
    private String productBoardContent;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public Product toEntity() {
        return Product.builder()
                .productId(productId)
                .userId(userId)
                .productNameKor(productNameKor)
                .productPrice(productPrice)
                .productImageUrl(productImageUrl)
                .productCategoryId(productCategoryId)
                .productAnimalCategoryId(productAnimalCategoryId)
                .productBoardContent(productBoardContent)
                .build();
    }
}
