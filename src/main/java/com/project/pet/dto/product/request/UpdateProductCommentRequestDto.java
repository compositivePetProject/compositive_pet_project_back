package com.project.pet.dto.product.request;

import com.project.pet.entity.product.ProductComment;
import lombok.Data;

@Data
public class UpdateProductCommentRequestDto {

    private String productCommentContent;

    public ProductComment toEntity(int productCommentId) {
        return ProductComment.builder()
                .productCommentId(productCommentId)
                .productCommentContent(productCommentContent)
                .build();
    }

}
