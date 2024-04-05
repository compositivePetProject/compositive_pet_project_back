package com.project.pet.repository;

import com.project.pet.entity.Product;
import com.project.pet.entity.ProductFavorite;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductFavoriteMapper {
    public Product getProductFavoritesCount(int productId);
    public int saveProductFavorite(ProductFavorite productFavorite);
    public int deleteProductFavorite(int userId);
}
