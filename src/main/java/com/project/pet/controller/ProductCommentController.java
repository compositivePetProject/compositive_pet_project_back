package com.project.pet.controller;

import com.project.pet.dto.product.request.PostProductCommentRequestDto;
import com.project.pet.dto.product.request.UpdateProductCommentRequestDto;
import com.project.pet.service.ProductCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product")
public class ProductCommentController {

    @Autowired
    private ProductCommentService productCommentService;

    @PostMapping("/comment")
    public ResponseEntity<?> saveProductComment(@RequestBody PostProductCommentRequestDto postProductCommentRequestDto) {
        productCommentService.saveProductComment(postProductCommentRequestDto);
        return ResponseEntity.created(null).body(true);
    }

    @GetMapping("/comments")
    public ResponseEntity<?> getAllProductComments() {
        return ResponseEntity.ok(productCommentService.getAllProductComments());
    }

    @DeleteMapping("/comment/delete/{productCommentId}")
    public ResponseEntity<?> deleteProductComment(@PathVariable int productCommentId) {
        productCommentService.deleteProductComment(productCommentId);
        return ResponseEntity.ok(true);
    }

    @PutMapping("/comment/update/{productCommentId}")
    public ResponseEntity<?> updateProductComment(@PathVariable int productCommentId, @RequestBody UpdateProductCommentRequestDto updateProductCommentRequestDto){
        productCommentService.updateProductComment(productCommentId, updateProductCommentRequestDto);
        return ResponseEntity.ok(true);
    }



}
