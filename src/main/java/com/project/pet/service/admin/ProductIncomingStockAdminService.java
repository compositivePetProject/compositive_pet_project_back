package com.project.pet.service.admin;

import com.project.pet.entity.incomingProduct.PutProductIncomingCheckAdminRequestDto;
import com.project.pet.entity.product.ProductStock;
import com.project.pet.repository.admin.ProductIncomingStockAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductIncomingStockAdminService {

    @Autowired
    ProductIncomingStockAdminMapper productIncomingStockAdminMapper;
    public void putProductIncomingCheckAdmin(PutProductIncomingCheckAdminRequestDto putProductIncomingCheckAdminRequestDto) {
        int productIncomingStockCount = putProductIncomingCheckAdminRequestDto.getProductIncomingStockCount();

        ProductStock productStock = productIncomingStockAdminMapper.getProductStock(putProductIncomingCheckAdminRequestDto.toEntity());

        putProductIncomingCheckAdminRequestDto.setProductIncomingStockCount(productIncomingStockCount + productStock.getProductStockCount());

        productIncomingStockAdminMapper.putProductIncomingCheckAdmin(putProductIncomingCheckAdminRequestDto.toEntity());
    }

}
