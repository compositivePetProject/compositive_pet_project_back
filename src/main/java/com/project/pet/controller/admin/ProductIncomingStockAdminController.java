package com.project.pet.controller.admin;

import com.project.pet.dto.admin.incomingProduct.request.*;
import com.project.pet.service.admin.ProductIncomingStockAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class ProductIncomingStockAdminController {

    @Autowired
    ProductIncomingStockAdminService productIncomingAdminService;

    // 관리자 가입고 상품 승인 완료
    @PutMapping("/incoming/stock/check")
    public ResponseEntity<?> putProductIcomingCheckAdmin(@RequestBody PutProductIncomingCheckAdminRequestDto putProductIncomingCheckAdminRequestDto) {
        productIncomingAdminService.putProductIncomingCheckAdmin(putProductIncomingCheckAdminRequestDto);
        return ResponseEntity.ok(true);
    }

    //[애완용품 쇼핑몰 가입고]
    // 관리자 상품 가입고 테이블 등록(단건)
    @PostMapping("/incoming/stock")
    public ResponseEntity<?> postProductIncomingStock(@RequestBody PostProductIncomingStockRequestDto postProductIncomingStockRequestDto) {
        productIncomingAdminService.postProductIncomingStock(postProductIncomingStockRequestDto);
        return ResponseEntity.created(null).body(true);
    }

    // 관리자 상품 가입고 테이블 수정(단건)
    @PutMapping("/incoming/stock/{productIncomingStockId}")
    public ResponseEntity<?> putProductIncomingStockAdmin(@PathVariable int productIncomingStockId, @RequestBody PutProductIncomingStockAdminRequestDto putProductIncomingStockAdminRequestDto) {
        productIncomingAdminService.putProductIncomingStockAdmin(productIncomingStockId, putProductIncomingStockAdminRequestDto);
        return ResponseEntity.ok(true);
    }

    // 관리자 상품 가입고 테이블 삭제(다건)
    @DeleteMapping("/incoming/stocks")
    public ResponseEntity<?> deleteProductIncomingStocksAdmin(@RequestBody List<Integer> productIncomingStockIds) {
        productIncomingAdminService.deleteProductIncomingStocksAdmin(productIncomingStockIds);
        return ResponseEntity.ok(true);
    }

    // 관리자 상품 가입고 테이블 조회(다건)
    @GetMapping("/incoming/stocks")
    public ResponseEntity<?> getProductIncomingStocks(GetProductIncomingStocksRequestDto getProductIncomingStocksRequestDto) {
        return ResponseEntity.ok(productIncomingAdminService.getProductIncomingStocks(getProductIncomingStocksRequestDto));
    }

    // 관리자 상품 가입고 페이지네이션 조회(다건)
    @GetMapping("/incoming/stocks/count")
    public ResponseEntity<?> getProductIncomingCount(GetProductIncomingCountRequestDto getProductIncomingCountRequestDto) {
        return ResponseEntity.ok(productIncomingAdminService.getProductIncomingCount(getProductIncomingCountRequestDto));
    }


//    @GetMapping("admin/incoming/stocks/test")
//    public ResponseEntity<?> getProductIncomingStocksTest(GetProductIncomingStocksTestRequestDto getProductIncomingStocksTestRequestDto) {
//        return ResponseEntity.ok(productAdminService.getProductIncomingStocksTest(getProductIncomingStocksTestRequestDto));
//    }
//

//

//
//
//    // 관리자 상품 가입고 테이블 조회(단건)
//    @GetMapping("admin/incoming/stock/{productIncomingStockId}")
//    public ResponseEntity<?> getProductIncomingStock(@PathVariable int productIncomingStockId) {
//        return ResponseEntity.ok(productAdminService.getProductIncomingStock(productIncomingStockId));
//    }
//
//    // 관리자 상품 가입고 테이블 삭제(단건)
//    @DeleteMapping("admin/incoming/stock/{productIncomingStockId}")
//    public ResponseEntity<?> deleteProductIncomingStock(@PathVariable int productIncomingStockId) {
//        productAdminService.deleteProductIncomingStock(productIncomingStockId);
//        return ResponseEntity.ok(true);
//    }
//

//



}
