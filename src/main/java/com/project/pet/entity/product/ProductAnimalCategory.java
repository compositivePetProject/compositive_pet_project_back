package com.project.pet.entity.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductAnimalCategory {
    private int productAnimalCategoryId;
    private String productAnimalCategoryName;
    private String productAnimalCategoryNameKor;
}
