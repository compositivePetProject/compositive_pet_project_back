package com.project.pet.entity;

import com.project.pet.dto.product.response.GetProductsAdminResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
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

    public GetProductsAdminResponseDto toGetProductsAdminResponseDto() {
        return GetProductsAdminResponseDto.builder()
                .productId(productId)
                .userId(userId)
                .productNameKor(productNameKor)
                .productPrice(productPrice)
                .productImageUrl(productImageUrl)
                .productCategoryId(productCategoryId)
                .productAnimalCategoryId(productAnimalCategoryId)
                .productBoardContent(productBoardContent)
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }
}
