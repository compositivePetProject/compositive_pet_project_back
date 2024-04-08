package com.project.pet.repository;

import com.project.pet.entity.product.ProductOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductOrderMapper {
    public int postProductOrder(ProductOrder productOrder);

    public List<ProductOrder> getProductOrders();
}
