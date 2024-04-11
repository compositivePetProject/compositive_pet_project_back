package com.project.pet.entity.product;

import com.project.pet.dto.product.response.GetProductOutgoingStocksAdminResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductOutgoingStock {
    private int productOutgoingStockId;
    private int productOrderId;
    private int productId;
    private int productSizeCategoryId;
    private int productOutgoingStockCount;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    private ProductOrder productOrder;
    private Product product;
    private ProductSizeCategory productSizeCategory;

    public GetProductOutgoingStocksAdminResponseDto toGetProductOutgoingStocksAdminResponseDto() {
        return GetProductOutgoingStocksAdminResponseDto.builder()
                .productOutgoingStockId(productOutgoingStockId)
                .productOrderId(productOrderId)
                .productId(productId)
                .productNameKor(product.getProductNameKor())
                .productSizeCategoryId(productSizeCategoryId)
                .productSizeCategoryName(productSizeCategory.getProductSizeCategoryName())
                .productSizeCategoryNameKor(productSizeCategory.getProductSizeCategoryNameKor())
                .productOutgoingStockCount(productOutgoingStockCount)
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }
}
