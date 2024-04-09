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
public class ProductOrderDetail {
    private int productOrderDetailId;
    private int productOrderId;
    private int productId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
