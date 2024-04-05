package com.project.pet.service;

import com.project.pet.dto.product.response.ProductFavoriteResponseDto;
import com.project.pet.entity.Product;
import com.project.pet.repository.ProductFavoriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductFavoriteService {

    @Autowired
    private ProductFavoriteMapper productFavoriteMapper;

    public ProductFavoriteResponseDto getProductFavoritesCount (int productId) {
//        return productFavoriteMapper.getProductFavoritesCount(productId).toProductFavoriteResponseDto();
        return null;
    }
}
