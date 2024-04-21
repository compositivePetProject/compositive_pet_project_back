package com.project.pet.service;

import com.project.pet.dto.product.request.*;
import com.project.pet.dto.product.response.ProductCommentResponseDto;
import com.project.pet.entity.product.ProductCommentRating;
import com.project.pet.entity.user.PrincipalUser;
import com.project.pet.entity.product.ProductComment;
import com.project.pet.repository.ProductCommentMapper;
import com.project.pet.repository.ProductCommentRatingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCommentService {
    @Autowired
    private ProductCommentMapper productCommentMapper;
    @Autowired
    private ProductCommentRatingMapper productCommentRatingMapper;
    private PrincipalUser getPrincipalUser () {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();
        return principalUser;
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveProductComment(PostProductCommentsRequestDto postProductCommentRequestDto) {
        int successCount = 0;
        ProductComment productComment = postProductCommentRequestDto.toEntity();
        successCount += productCommentMapper.saveProductComment(productComment);
        successCount += productCommentRatingMapper.savaProductCommentRating(
                ProductCommentRating.builder()
                        .productCommentId(productComment.getProductCommentId())
                        .userId(productComment.getUserId())
                        .productCommentRatingValue(postProductCommentRequestDto.productCommentRatingValue)
                        .build()
        );
        if(successCount < 2) {
            throw new RuntimeException("데이터 저장 오류");
        }
    }

    public List<ProductCommentResponseDto> getProductComment(GetProductCommentRequestDto getProductCommentRequestDto) {
        List<ProductComment> productComments = productCommentMapper.getProductCommentsByUserId(getProductCommentRequestDto.getUserId());
        return productComments.stream().map(ProductComment::toProductCommentResponseDto).collect(Collectors.toList());
    }

    public List<ProductCommentResponseDto> getAllProductComments(GetProductCommentsRequestDto getProductCommentRequestDto) {
        List<ProductComment> productComments = productCommentMapper.getAllProductCommentsByProductId(getProductCommentRequestDto.getProductId());
        return productComments.stream().map(ProductComment::toProductCommentResponseDto).collect(Collectors.toList());
    }

    public void deleteProductComment(DeleteProductCommentRequestDto deleteProductCommentRequestDto) {
        productCommentMapper.deleteProductComment(deleteProductCommentRequestDto.getProductCommentId());
    }

    public void updateProductComment(UpdateProductCommentRequestDto updateProductCommentRequestDto) {
        ProductComment productComment = updateProductCommentRequestDto.toEntity();
        productCommentMapper.updateProductComment(productComment);
        productCommentRatingMapper.updateProductCommentRating(
                ProductCommentRating.builder()
                        .productCommentRatingId(updateProductCommentRequestDto.getProductCommentRatingId())
                        .productCommentRatingValue(updateProductCommentRequestDto.getProductCommentRatingValue())
                        .build()
        );
    }
}
