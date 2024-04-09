package com.project.pet.repository;

import com.project.pet.entity.product.ProductOrderDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductOrderDetailMapper {
    public int postProductOrderDetail(ProductOrderDetail productOrderDetail);
}
