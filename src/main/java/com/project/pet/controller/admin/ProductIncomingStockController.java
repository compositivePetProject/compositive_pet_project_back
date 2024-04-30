package com.project.pet.controller.admin;

import com.project.pet.entity.incomingProduct.PutProductIncomingCheckAdminRequestDto;
import com.project.pet.service.admin.ProductIncomingStockAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class ProductIncomingStockController {

    @Autowired
    ProductIncomingStockAdminService productIncomingAdminService;

    // 관리자 가입고 상품 승인 완료
    @PutMapping("/incoming/stock/check")
    public ResponseEntity<?> putProductIcomingCheckAdmin(@RequestBody PutProductIncomingCheckAdminRequestDto putProductIncomingCheckAdminRequestDto) {
        productIncomingAdminService.putProductIncomingCheckAdmin(putProductIncomingCheckAdminRequestDto);
        return ResponseEntity.ok(true);
    }
}
