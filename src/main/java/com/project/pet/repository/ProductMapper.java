package com.project.pet.repository;

import com.project.pet.entity.product.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    public Product getProduct(@Param("productId") int productId);

    public List<Product> getProducts();
}
