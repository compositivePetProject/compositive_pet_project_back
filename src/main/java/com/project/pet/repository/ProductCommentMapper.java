package com.project.pet.repository;

import com.project.pet.entity.ProductComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductCommentMapper {
    public int saveProductComment(ProductComment productComment);
    public List<ProductComment> getAllProductComments();
    public int deleteProductComment(int productCommentId);
    public int updateProductComment(ProductComment productComment);
}