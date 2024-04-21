package com.project.pet.repository;

import com.project.pet.entity.product.ProductComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductCommentMapper {
    public int saveProductComment(ProductComment productComment);
    public List<ProductComment> getProductCommentsByUserId(int userId);
    public List<ProductComment> getAllProductCommentsByProductId(int productId);
    public int deleteProductComment(int productCommentId);
    public int updateProductComment(ProductComment productComment);

}
