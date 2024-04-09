package com.project.pet.dto.product.request;

import com.project.pet.entity.product.ProductOrder;
import lombok.Data;

@Data
public class PutProductOrderRequestDto {
    private int productOrderId;
    private String productOrderAddress;
    private String productDetailOrderAddress;
    private int productSizeCategoryId;
    private int productOrderCount;

    public ProductOrder toEntity() {
        return ProductOrder.builder()
                .productOrderId(productOrderId)
                .productOrderAddress(productOrderAddress)
                .productOrderDetailAddress(productDetailOrderAddress)
                .productSizeCategoryId(productSizeCategoryId)
                .productOrderCount(productOrderCount)
                .build();
    }
}
