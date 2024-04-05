package com.project.pet.controller.admin;

import com.project.pet.dto.product.request.PostProductAdminRequestDto;
import com.project.pet.dto.product.request.PostProductIncomingStockRequestDto;
import com.project.pet.dto.product.request.PutProductAdminRequestDto;
import com.project.pet.service.admin.ProductAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductAdminController {

    @Autowired
    ProductAdminService productAdminService;

    // 관리자 상품 등록(단건)
    @PostMapping("/admin")
    public ResponseEntity<?> postProductAdmin(@RequestBody PostProductAdminRequestDto postProductAdminRequestDto) {
        productAdminService.postProductAdmin(postProductAdminRequestDto);
        return ResponseEntity.created(null).body(true);
    }

    // 관리자 상품 조회(다건)
    @GetMapping("/admin/products")
    public ResponseEntity<?> getProductsAdmin() {
        return ResponseEntity.ok(productAdminService.getProductsAdmin());
    }

    // 관리자 상품 삭제(단건)
    @DeleteMapping("/admin/product/{productId}")
    public ResponseEntity<?> deleteProductAdmin(@PathVariable Integer productId) {
        productAdminService.deleteProductAdmin(productId);
        return ResponseEntity.created(null).body(true);
    }

    // 관리자 상품 수정(단건)
    @PutMapping("/admin/product/{productId}")
    public ResponseEntity<?> putProductAdmin(@PathVariable Integer productId, @RequestBody PutProductAdminRequestDto putProductAdminRequestDto) {
        productAdminService.putProductAdmin(productId, putProductAdminRequestDto);
        return ResponseEntity.created(null).body(true);
    }

    // 관리자 상품 삭제(다건)
    @DeleteMapping("/admin/products")
    public ResponseEntity<?> deleteProductsAdmin(@RequestBody List<Integer> productIds) {
        productAdminService.deleteProductsAdmin(productIds);
        return ResponseEntity.ok(true);
    }

    // 관리자 상품 가입고 테이블 등록(단건)
    @PostMapping("/admin/incoming/stock")
    public ResponseEntity<?> postProductIncomingStock(@RequestBody PostProductIncomingStockRequestDto postProductIncomingStockRequestDto) {
        productAdminService.postProductIncomingStock(postProductIncomingStockRequestDto);
        return ResponseEntity.created(null).body(true);
    }

    // 관리자 상품 가입고 테이블 조회(다건)
    @GetMapping("admin/incoming/stocks")
    public ResponseEntity<?> getProductIncomingStocks() {
        return ResponseEntity.ok(productAdminService.getProductIncomingStocks());
    }

    // 관리자 상품 가입고 테이블 삭제(단건)
    @DeleteMapping("admin/incoming/stock/{productIncomingStockId}")
    public ResponseEntity<?> deleteProductIncomingStock(@PathVariable int productIncomingStockId) {
        productAdminService.deleteProductIncomingStock(productIncomingStockId);
        return ResponseEntity.ok(true);
    }

    // 관리자 상품 가입고 테이블 삭제(다건)
    @DeleteMapping("admin/incoming/stocks")
    public ResponseEntity<?> deleteProductIncomingStocksAdmin(@RequestBody List<Integer> productIncomingStockIds) {
        productAdminService.deleteProductIncomingStocksAdmin(productIncomingStockIds);
        return ResponseEntity.ok(true);
    }
}
