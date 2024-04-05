package com.project.pet.repository;

import com.project.pet.entity.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductFavoriteMapper {
    public Product getProductFavoritesCount(int productId);
}
