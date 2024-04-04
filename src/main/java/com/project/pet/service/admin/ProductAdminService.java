package com.project.pet.service.admin;

import com.project.pet.dto.product.request.PostProductAdminRequestDto;
import com.project.pet.dto.product.request.PutProductAdminRequestDto;
import com.project.pet.dto.product.response.GetProductsAdminResponseDto;
import com.project.pet.entity.Product;
import com.project.pet.repository.admin.ProductAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
