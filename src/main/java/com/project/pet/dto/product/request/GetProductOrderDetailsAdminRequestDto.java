package com.project.pet.dto.product.request;

import lombok.Data;

@Data
public class GetProductOrderDetailsAdminRequestDto {
    private int page;
    private int count;
    private int productCategoryId;
    private int productAnimalCategoryId;
    private int productSizeCategoryId;
    private String productNameKor;
}
