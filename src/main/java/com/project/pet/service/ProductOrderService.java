package com.project.pet.service;

import com.project.pet.dto.product.request.PostProductOrderRequestDto;
import com.project.pet.repository.ProductOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductOrderService {

    @Autowired
    ProductOrderMapper productOrderMapper;

    public void postProductOrder(PostProductOrderRequestDto postProductOrderRequestDto) {
        productOrderMapper.postProductOrder(postProductOrderRequestDto.toEntity());
    }

}
