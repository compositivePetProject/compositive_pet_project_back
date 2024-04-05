package com.project.pet.controller;

import com.project.pet.service.ProductFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductFavoriteController {

    @Autowired
    private ProductFavoriteService productFavoriteService;

    @GetMapping("/favorites/count/{productId}")
    public ResponseEntity<?> getProductFavoritesCount (@PathVariable int productId) {
        return ResponseEntity.ok(productFavoriteService.getProductFavoritesCount(productId));
    }
}
