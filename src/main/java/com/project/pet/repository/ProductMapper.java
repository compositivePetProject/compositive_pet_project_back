package com.project.pet.repository;

import com.project.pet.entity.product.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    public Product getProduct(@Param("productId") int productId);

    public List<Product> getProducts();

    public List<Product> findProducts(
            @Param("startIndex") int startIndex,
            @Param("count") int count,
            @Param("productCategoryId") int productCategoryId,
            @Param("searchText") String searchText);


    public int getProductCount(
            @Param("productCategoryId") int productCategoryId,
            @Param("searchText") String searchText);
}
