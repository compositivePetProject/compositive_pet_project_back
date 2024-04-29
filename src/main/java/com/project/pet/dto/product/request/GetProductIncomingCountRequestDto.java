package com.project.pet.dto.product.request;

import lombok.Data;

@Data
public class GetProductIncomingCountRequestDto {
    private int count;
    private int productSizeCategoryId;
    private String productNameKor;
}
