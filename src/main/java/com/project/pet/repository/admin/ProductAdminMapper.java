package com.project.pet.repository.admin;

import com.project.pet.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductAdminMapper {
    public int postProductAdmin(Product product);

    public List<Product> getProductsAdmin();

    public int deleteProductAdmin(int productId);

    public int putProductAdmin(Product product);
}
