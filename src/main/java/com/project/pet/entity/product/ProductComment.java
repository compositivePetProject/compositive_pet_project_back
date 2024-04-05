package com.project.pet.entity.product;

import com.project.pet.dto.product.response.ProductCommentResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductComment {

    private int productCommentId;
    private int productId;
    private int userId;
    private String productCommentContent;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public ProductCommentResponseDto toProductCommentResponseDto() {
        return ProductCommentResponseDto.builder()
                .productCommentId(productCommentId)
                .productId(productId)
                .userId(userId)
                .productCommentContent(productCommentContent)
                .build();
    }

}
