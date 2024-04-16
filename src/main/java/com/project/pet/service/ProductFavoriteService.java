package com.project.pet.service;

import com.project.pet.dto.product.request.DeleteProductFavoriteRequestDto;
import com.project.pet.dto.product.request.GetProductRequestDto;
import com.project.pet.dto.product.request.PostProductFavoriteRequestDto;
import com.project.pet.dto.product.response.ProductFavoriteResponseDto;
import com.project.pet.entity.user.PrincipalUser;
import com.project.pet.repository.ProductFavoriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ProductFavoriteService {

    @Autowired
    private ProductFavoriteMapper productFavoriteMapper;

    public ProductFavoriteResponseDto getProductFavoritesCount (GetProductRequestDto getProductRequestDto) {
        return productFavoriteMapper.getProductFavoritesCount(getProductRequestDto.getProductId()).toProductFavoriteResponseDto();
    }

    public void saveProductFavorite(PostProductFavoriteRequestDto postProductFavoriteRequestDto) {
        productFavoriteMapper.saveProductFavorite(postProductFavoriteRequestDto.toEntity());
    }

    public void deleteProductFavorite(DeleteProductFavoriteRequestDto deleteProductFavoriteRequestDto) {
        productFavoriteMapper.deleteProductFavorite(deleteProductFavoriteRequestDto.getUserId());
    }
}
