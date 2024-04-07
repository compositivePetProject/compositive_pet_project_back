package com.project.pet.entity.product;

import com.project.pet.dto.product.response.GetProductStocksAdminResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductStock {
    private int productStockId;
    private int productId;
    private int productSizeCategoryId;
    private int productStockCount;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public GetProductStocksAdminResponseDto toGetProductStocksResponseDto() {
        return GetProductStocksAdminResponseDto.builder()
                .productStockId(productStockId)
                .productId(productId)
                .productSizeCategoryId(productSizeCategoryId)
                .productStockCount(productStockCount)
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }
}
