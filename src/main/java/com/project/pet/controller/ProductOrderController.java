package com.project.pet.controller;

import com.project.pet.dto.product.request.PostProductOrderRequestDto;
import com.project.pet.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductOrderController {

    @Autowired
    ProductOrderService productOrderService;

    @PostMapping("/product/order")
    public ResponseEntity<?> postProductOrder(@RequestBody PostProductOrderRequestDto postProductOrderRequestDto) {
        productOrderService.postProductOrder(postProductOrderRequestDto);
        return ResponseEntity.created(null).body(true);
    }

}
