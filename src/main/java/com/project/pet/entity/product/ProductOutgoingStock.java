package com.project.pet.entity.product;

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
    private int productId;
    private int productSizeCategoryId;
    private int productOutgoingStockCount;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
