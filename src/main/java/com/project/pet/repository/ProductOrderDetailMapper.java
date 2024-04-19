package com.project.pet.repository;

import com.project.pet.entity.product.ProductOrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductOrderDetailMapper {
    public int postProductOrderDetail(ProductOrderDetail productOrderDetail);

    public int deleteProductOrder(int productOrderId);

    public int deleteProductOrders(List<Integer> productOrderIds);

    public List<ProductOrderDetail> getProductOrderDetailsAdmin(
            @Param("startIndex") int startIndex,
            @Param("count") int count,
            @Param("productCategoryId") int productCategoryId,
            @Param("productAnimalCategoryId") int productAnimalCategoryId,
            @Param("productSizeCategoryId") int productSizeCategoryId,
            @Param("productNameKor") String productNameKor
    );
}
