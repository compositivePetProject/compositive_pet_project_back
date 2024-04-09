package com.project.pet.entity.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductSizeCategory {
    private int productSizeCategoryId;
    private String productSizeCategoryName;
    private String productSizeCategoryNameKor;
}
