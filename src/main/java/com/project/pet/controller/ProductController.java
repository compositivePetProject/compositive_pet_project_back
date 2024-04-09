package com.project.pet.controller;

import com.project.pet.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    // 사용자 상품 조회(단건)
    @GetMapping("/{productId}")
    public ResponseEntity<?> getProduct(@PathVariable int productId) {
        return ResponseEntity.ok(productService.getProduct(productId));
    }

    // 사용자 상품 조회(다건)
    @GetMapping("/")
    public ResponseEntity<?> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }
}
