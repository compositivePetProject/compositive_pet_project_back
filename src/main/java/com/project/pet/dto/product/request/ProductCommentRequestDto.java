package com.project.pet.dto.product.request;

import com.project.pet.entity.ProductComment;
import lombok.Data;

@Data
public class ProductCommentRequestDto {
    private String productCommentContent;

    public ProductComment toEntity(int productCommentId,int productId, int userId){
        return ProductComment.builder()
                .productCommentId(productCommentId)
                .productId(productId)
                .userId(userId)
                .productCommentContent(productCommentContent)
                .build();
    }
}
