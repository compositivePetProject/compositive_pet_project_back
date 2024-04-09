package com.project.pet.service;

import com.project.pet.dto.product.request.PostProductCommentRequestDto;
import com.project.pet.dto.product.request.UpdateProductCommentRequestDto;
import com.project.pet.dto.product.response.ProductCommentResponseDto;
import com.project.pet.entity.user.PrincipalUser;
import com.project.pet.entity.product.ProductComment;
import com.project.pet.repository.ProductCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCommentService {
    @Autowired
    private ProductCommentMapper productCommentMapper;

    private PrincipalUser getPrincipalUser () {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();
        return principalUser;
    }

    public void saveProductComment(PostProductCommentRequestDto postProductCommentRequestDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();
        productCommentMapper.saveProductComment(postProductCommentRequestDto.toEntity(principalUser.getUserId()));
    }

    public List<ProductCommentResponseDto> getAllProductComments() {
        List<ProductComment> productComments = productCommentMapper.getAllProductComments();
        return productComments.stream().map(ProductComment::toProductCommentResponseDto).collect(Collectors.toList());
    }

    public void deleteProductComment(int productCommentId) {
        productCommentMapper.deleteProductComment(productCommentId);
    }

    public void updateProductComment(int productCommentId, UpdateProductCommentRequestDto updateProductCommentRequestDto) {
        productCommentMapper.updateProductComment(updateProductCommentRequestDto.toEntity(productCommentId));
    }
}
