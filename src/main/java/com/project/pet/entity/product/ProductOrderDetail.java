package com.project.pet.entity.product;

import com.project.pet.dto.product.response.GetProductOrderDetailsAdminResponseDto;
import com.project.pet.entity.user.User;
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

    private ProductOrder productOrder;
    private Product product;
    private ProductSizeCategory productSizeCategory;
    private User user;

    public GetProductOrderDetailsAdminResponseDto toGetProductOrderDetailsAdminResponseDto() {
        return GetProductOrderDetailsAdminResponseDto.builder()
                .productOrderDetailId(productOrderDetailId)
                .productOrderId(productOrderId)
                .productId(productId)
                .productNameKor(product.getProductNameKor())
                .productSizeCategoryId(productOrder.getProductSizeCategoryId())
                .productSizeCategoryName(productSizeCategory.getProductSizeCategoryName())
                .productSizeCategoryNameKor(productSizeCategory.getProductSizeCategoryNameKor())
                .productOrderCount(productOrder.getProductOrderCount())
                .userId(productOrder.getUserId())
                .userName(user.getName())
                .productOrderAddress(productOrder.getProductOrderAddress())
                .productOrderDetailAddress(productOrder.getProductOrderDetailAddress())
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }
}
