package com.project.pet.repository.admin;

import com.project.pet.entity.product.ProductStock;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductIncomingStockAdminMapper {

    public ProductStock getProductStock(ProductStock productStock);
    public int putProductIncomingCheckAdmin(ProductStock productStock);

}
