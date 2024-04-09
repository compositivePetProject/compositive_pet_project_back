package com.project.pet.dto.product.request;

import com.project.pet.entity.product.ProductComment;
import com.project.pet.entity.product.ProductOrder;
import lombok.Data;

@Data
public class PostProductCommentRequestDto {
    private int productId;
    private String productCommentContent;

    public ProductComment toEntity(int userId) {
        return ProductComment.builder()
                .productId(productId)
                .userId(userId)
                .productCommentContent(productCommentContent)
                .build();
    }
}
