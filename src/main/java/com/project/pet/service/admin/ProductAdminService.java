package com.project.pet.service.admin;

import com.project.pet.dto.product.request.*;
import com.project.pet.dto.product.response.*;
import com.project.pet.entity.product.Product;
import com.project.pet.entity.product.ProductIncomingStock;
import com.project.pet.entity.product.ProductOutgoingStock;
import com.project.pet.entity.product.ProductStock;
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
        Product product = postProductAdminRequestDto.toEntity();
        productAdminMapper.postProductAdmin(product);
        int productId = product.getProductId();
        productAdminMapper.postProductStockAdmin(ProductStock.builder().productId(productId).build());
    }

    public GetProductAdminResponseDto getProductAdmin(int productId) {
        Product product = productAdminMapper.getProductAdmin(productId);
        return product.toGetProductAdminResponseDto();
    }

    public List<GetProductsAdminResponseDto> getProductsAdmin() {
        List<Product> list = productAdminMapper.getProductsAdmin();
        return list.stream().map(Product::toGetProductsAdminResponseDto).collect(Collectors.toList());
    }

    public void deleteProductAdmin(int productId) {
        int success = productAdminMapper.deleteProductAdmin(productId);
    }

    public void putProductAdmin(int productId, PutProductAdminRequestDto putProductAdminRequestDto) {
        putProductAdminRequestDto.setProductId(productId);
        productAdminMapper.putProductAdmin(putProductAdminRequestDto.toEntity());
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

    public GetProductIncomingStockResponseDto getProductIncomingStock(int productIncomingStockId) {
        ProductIncomingStock productIncomingStock = productAdminMapper.getProductIncomingStock(productIncomingStockId);
        return productIncomingStock.toGetProductIncomingStockResponseDto();
    }


    public void deleteProductIncomingStock(int productIncomingStockId) {
        productAdminMapper.deleteProductIncomingStock(productIncomingStockId);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteProductIncomingStocksAdmin(List<Integer> productIncomingStockIds) {
        productAdminMapper.deleteProductIncomingStocksAdmin(productIncomingStockIds);
    }

    public void putProductIncomingStockAdmin(int productIncomingStockId, PutProductIncomingStockAdminRequestDto putProductIncomingStockAdminRequestDto) {
        putProductIncomingStockAdminRequestDto.setProductIncomingStockId(productIncomingStockId);
        productAdminMapper.putProductIncomingStockAdmin(putProductIncomingStockAdminRequestDto.toEntity());
    }

    public void postProductStockAdmin(PostProductStockAdminRequestDto postProductStockAdminRequestDto) {
        productAdminMapper.postProductStockAdmin(postProductStockAdminRequestDto.toEntity());
    }

    public List<GetProductStocksAdminResponseDto> getProductStocksAdmin() {
        List<ProductStock> list = productAdminMapper.getProductStocksAdmin();
        return list.stream().map(ProductStock::toGetProductStocksResponseDto).collect(Collectors.toList());
    }

    public GetProductStockAdminResponseDto getProductStockAdmin(int productStockId) {
        ProductStock productStock = productAdminMapper.getProductStockAdmin(productStockId);
        return productStock.toGetProductStockAdminResponseDto();
    }

    public void deleteProductStockAdmin(int productStockId) {
        productAdminMapper.deleteProductStockAdmin(productStockId);
    };

    @Transactional(rollbackFor = Exception.class)
    public void deleteProductStocksAdmin(List<Integer> productStockIds) {
        productAdminMapper.deleteProductStocksAdmin(productStockIds);
    }

    public void putProductStockAdmin(int productStockId, PutProductStockAdminRequestDto productStockAdminRequestDto) {
        productStockAdminRequestDto.setProductStockId(productStockId);
        productAdminMapper.putProductStockAdmin(productStockAdminRequestDto.toEntity());
    }

    public void postProductOutgoingStockAdmin(PostProductOutgoingStockAdminRequestDto postProductOutgoingStockAdminRequestDto) {
        productAdminMapper.postProductOutgoingStockAdmin(postProductOutgoingStockAdminRequestDto.toEntity());
    }

    public List<GetProductOutgoingStocksAdminResponseDto> getProductOutgoingStocksAdmin() {
        List<ProductOutgoingStock> list = productAdminMapper.getProductOutgoingStocksAdmin();
        return list.stream().map(ProductOutgoingStock::toGetProductOutgoingStocksAdminResponseDto).collect(Collectors.toList());
    }

    public void deleteProductOutgoingStockAdmin(int productOutgoingStockId) {
        productAdminMapper.deleteProductOutgoingStockAdmin(productOutgoingStockId);
    }

    public void deleteProductOutgoingStocksAdmin(List<Integer> productOutgoingStockIds) {
        productAdminMapper.deleteProductOutgoingStocksAdmin(productOutgoingStockIds);
    }

    public void putProductOutgoingStockAdmin(int productOutgoingStockId, PutProductOutgoingStockAdminRequestDto putProductOutgoingStockAdminRequestDto) {
        putProductOutgoingStockAdminRequestDto.setProductOutgoingStockId(productOutgoingStockId);
        productAdminMapper.putProductOutgoingStockAdmin(putProductOutgoingStockAdminRequestDto.toEntity());
    }

}
