package com.project.pet.dto.product.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ProductFavoriteResponseDto {
        private int productId;
        private int userId;
        private String productNameKor;
        private int productPrice;
        private String productImageUrl;
        private int productCategoryId;
        private int productAnimalCategoryId;
        private String productBoardContent;
        private int productFavoriteId;
        private int totalFavoriteCount;
        private LocalDateTime createDate;
        private LocalDateTime updateDate;
}
