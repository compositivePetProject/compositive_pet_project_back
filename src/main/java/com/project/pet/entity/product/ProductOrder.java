package com.project.pet.entity.product;

import com.project.pet.dto.product.response.GetProductOrdersResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductOrder {
    private int productOrderId;
    private int userId;
    private int productId;
    private String productOrderAddress;
    private String productOrderDetailAddress;
    private int productSizeCategoryId;
    private int productOrderCount;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public GetProductOrdersResponseDto toGetProductOrdersResponseDto() {
        return GetProductOrdersResponseDto.builder()
                .productOrderId(productOrderId)
                .userId(userId)
                .productId(productId)
                .productOrderAddress(productOrderAddress)
                .productDetailOrderAddress(productOrderDetailAddress)
                .productSizeCategoryId(productSizeCategoryId)
                .productOrderCount(productOrderCount)
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }
}
