package com.project.pet.dto.product.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetProductOrderDetailsAdminResponseDto {
    private int productOrderDetailId;
    private int productOrderId;
    private int productId;
    private String productNameKor;
    private int productSizeCategoryId;
    private String productSizeCategoryName;
    private String productSizeCategoryNameKor;
    private int productOrderCount;
    private int userId;
    private String userName;
    private String productOrderAddress;
    private String productOrderDetailAddress;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
