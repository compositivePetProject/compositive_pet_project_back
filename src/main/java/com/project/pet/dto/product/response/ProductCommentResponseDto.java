package com.project.pet.dto.product.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ProductCommentResponseDto {
    private int productCommentId;
    private int productId;
    private int userId;
    private String productCommentContent;
}
