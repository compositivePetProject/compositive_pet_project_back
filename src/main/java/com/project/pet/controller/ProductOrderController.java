package com.project.pet.controller;

import com.project.pet.dto.product.request.PostProductOrderRequestDto;
import com.project.pet.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductOrderController {

    @Autowired
    ProductOrderService productOrderService;

    // 사용자 상품 주문 등록(단건)
    @PostMapping("/product/order")
    public ResponseEntity<?> postProductOrder(@RequestBody PostProductOrderRequestDto postProductOrderRequestDto) {
        productOrderService.postProductOrder(postProductOrderRequestDto);
        return ResponseEntity.created(null).body(true);
    }

    // 사용자 상품 주문 조회(다건)
    @GetMapping("/product/orders")
    public ResponseEntity<?> getProductOrders() {
        return ResponseEntity.ok(productOrderService.getProductOrders());
    }

    // 사용자 상품 주문 삭제(단건)
    @DeleteMapping("/product/order/{productOrderId}")
    public ResponseEntity<?> deleteProductOrder(@PathVariable int productOrderId) {
        productOrderService.deleteProductOrder(productOrderId);
        return ResponseEntity.ok(true);
    }

}
