package com.project.pet.dto.product.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetProductOutgoingStocksAdminResponseDto {
    private int productOutgoingStockId;
    private int productId;
    private int productSizeCategoryId;
    private int productOutgoingStockCount;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
