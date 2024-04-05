package com.project.pet.service;

import com.project.pet.dto.product.request.PostProductFavoriteRequestDto;
import com.project.pet.dto.product.response.ProductFavoriteResponseDto;
import com.project.pet.entity.PrincipalUser;
import com.project.pet.repository.ProductFavoriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ProductFavoriteService {

    @Autowired
    private ProductFavoriteMapper productFavoriteMapper;

    public ProductFavoriteResponseDto getProductFavoritesCount (int productId) {
        return productFavoriteMapper.getProductFavoritesCount(productId).toProductFavoriteResponseDto();
    }

    public void saveProductFavorite(PostProductFavoriteRequestDto postProductFavoriteRequestDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();
        productFavoriteMapper.saveProductFavorite(postProductFavoriteRequestDto.toEntity(principalUser.getUserId()));
    }

    public void deleteProductFavorite() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();
        productFavoriteMapper.deleteProductFavorite(principalUser.getUserId());
    }
}
