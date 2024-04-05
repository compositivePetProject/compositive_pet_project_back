package com.project.pet.service.admin;

import com.project.pet.dto.product.request.PostProductAdminRequestDto;
import com.project.pet.dto.product.request.PostProductIncomingStockRequestDto;
import com.project.pet.dto.product.request.PutProductAdminRequestDto;
import com.project.pet.dto.product.response.GetProductIncomingStocksResponseDto;
import com.project.pet.dto.product.response.GetProductsAdminResponseDto;
import com.project.pet.entity.Product;
import com.project.pet.entity.ProductIncomingStock;
import com.project.pet.repository.admin.ProductAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductAdminService {

    @Autowired
    ProductAdminMapper productAdminMapper;

    public void postProductAdmin(PostProductAdminRequestDto postProductAdminRequestDto) {
        int success = productAdminMapper.postProductAdmin(postProductAdminRequestDto.toEntity());
    }

    public List<GetProductsAdminResponseDto> getProductsAdmin() {
        List<Product> list = null;
        list = productAdminMapper.getProductsAdmin();
        return list.stream().map(Product::toGetProductsAdminResponseDto).collect(Collectors.toList());
    }

    public void deleteProductAdmin(int productId) {
        int success = productAdminMapper.deleteProductAdmin(productId);
    }

    public void putProductAdmin(int productId, PutProductAdminRequestDto putProductAdminRequestDto) {
        putProductAdminRequestDto.setProductId(productId);
        int success = productAdminMapper.putProductAdmin(putProductAdminRequestDto.toEntity());
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteProductsAdmin(List<Integer> productIds) {
        productAdminMapper.deleteProductsAdmin(productIds);
    }

    public void postProductIncomingStock(PostProductIncomingStockRequestDto postProductIncomingStockRequestDto) {
        productAdminMapper.postProductIncomingStock(postProductIncomingStockRequestDto.toEntity());
    }

    public List<GetProductIncomingStocksResponseDto> getProductIncomingStocks() {
        List<ProductIncomingStock> list = productAdminMapper.getProductIncomingStocks();
        return list.stream().map(ProductIncomingStock::toGetProductIncomingStocksResponseDto).collect(Collectors.toList());
    }

}
