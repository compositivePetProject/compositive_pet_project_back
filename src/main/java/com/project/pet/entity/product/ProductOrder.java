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
public class ProductOrder {
    private int productOrderId;
    private int userId;
    private String productOrderAddress;
    private String productOrderDetailAddress;
    private int productSizeCategoryId;
    private int productOrderCount;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
