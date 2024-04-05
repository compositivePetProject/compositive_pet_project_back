package com.project.pet.entity;

import com.project.pet.dto.product.response.GetProductIncomingStocksResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductIncomingStock {
    private int productIncomingStockId;
    private int productId;
    private int productSizeCategoryId;
    private int productIncomingStockCount;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public GetProductIncomingStocksResponseDto toGetProductIncomingStocksResponseDto() {
        return GetProductIncomingStocksResponseDto.builder()
                .productIncomingStockId(productIncomingStockId)
                .productId(productId)
                .productSizeCategoryId(productSizeCategoryId)
                .productIncomingStockCount(productIncomingStockCount)
                .createDate(createDate)
                .updateDate(createDate)
                .build();
    }
}
