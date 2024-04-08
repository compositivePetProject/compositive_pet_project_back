package com.project.pet.service;

import com.project.pet.dto.product.request.PostProductOrderRequestDto;
import com.project.pet.dto.product.request.PutProductOrderRequestDto;
import com.project.pet.dto.product.response.GetProductOrdersResponseDto;
import com.project.pet.entity.product.ProductOrder;
import com.project.pet.repository.ProductOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductOrderService {

    @Autowired
    ProductOrderMapper productOrderMapper;

    public void postProductOrder(PostProductOrderRequestDto postProductOrderRequestDto) {
        productOrderMapper.postProductOrder(postProductOrderRequestDto.toEntity());
    }

    public List<GetProductOrdersResponseDto> getProductOrders() {
        List<ProductOrder> list = productOrderMapper.getProductOrders();
        return list.stream().map(ProductOrder::toGetProductOrdersResponseDto).collect(Collectors.toList());
    }

    public void deleteProductOrder(int productOrderId) {
        productOrderMapper.deleteProductOrder(productOrderId);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteProductOrders(List<Integer> productOrderIds) {
        productOrderMapper.deleteProductOrders(productOrderIds);
    }

    public void putProductOrder(int productOrderId, PutProductOrderRequestDto putProductOrderRequestDto) {
        putProductOrderRequestDto.setProductOrderId(productOrderId);
        productOrderMapper.putProductOrder(putProductOrderRequestDto.toEntity());
    }

}
