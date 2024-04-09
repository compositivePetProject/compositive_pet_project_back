package com.project.pet.entity.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductCategory {
    private int productCategoryId;
    private String productCategoryName;
    private String productCategoryNameKor;
}
