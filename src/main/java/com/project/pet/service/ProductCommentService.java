package com.project.pet.service;

import com.project.pet.dto.product.request.ProductCommentRequestDto;
import com.project.pet.entity.ProductComment;
import com.project.pet.repository.ProductCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCommentService {
    @Autowired
    private ProductCommentMapper productCommentMapper;

    public void saveProductComment(ProductCommentRequestDto productCommentRequestDto) {
        productCommentMapper.saveProductComment(productCommentRequestDto.toEntity(1, 3, 2));
    }

    public List<ProductComment> getAllProductComments() {
       return productCommentMapper.getAllProductComments();
    }

    public void deleteProductComment(int productCommentId) {
        productCommentMapper.deleteProductComment(productCommentId);
    }

    public void updateProductComment(int productCommentId, ProductCommentRequestDto productCommentRequestDto) {
        productCommentMapper.updateProductComment(productCommentRequestDto.toEntity(productCommentId, 3, 3));
    }


}
