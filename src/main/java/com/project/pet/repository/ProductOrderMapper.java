package com.project.pet.repository;

import com.project.pet.entity.product.ProductOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductOrderMapper {
    public int postProductOrder(ProductOrder productOrder);
}
