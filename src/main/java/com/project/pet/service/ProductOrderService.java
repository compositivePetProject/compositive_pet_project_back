package com.project.pet.service;

import com.project.pet.dto.product.request.GetProductOrdersRequestDto;
import com.project.pet.dto.product.request.PostProductOrderRequestDto;
import com.project.pet.dto.product.request.PutProductOrderRequestDto;
import com.project.pet.dto.product.response.GetProductOrderResponseDto;
import com.project.pet.dto.product.response.GetProductOrdersResponseDto;
import com.project.pet.entity.product.ProductOrder;
import com.project.pet.entity.product.ProductOrderDetail;
import com.project.pet.entity.product.ProductOutgoingStock;
import com.project.pet.repository.ProductOrderDetailMapper;
import com.project.pet.repository.ProductOrderMapper;
import com.project.pet.repository.admin.ProductAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductOrderService {

    @Autowired
    ProductOrderMapper productOrderMapper;
    @Autowired
    ProductOrderDetailMapper productOrderDetailMapper;

    @Autowired
    ProductAdminMapper productAdminMapper;


    public void postProductOrder(PostProductOrderRequestDto postProductOrderRequestDto) {
        ProductOrder productOrder = postProductOrderRequestDto.toEntity();

        productOrderMapper.postProductOrder(productOrder);

        int productOrderId = productOrder.getProductOrderId();
        int productId = productOrder.getProductId();
        int productSizeCategoryId = productOrder.getProductSizeCategoryId();
        int productOrderCount = productOrder.getProductOrderCount();



        productOrderDetailMapper.postProductOrderDetail(
                ProductOrderDetail.builder()
                .productOrderId(productOrderId)
                .productId(productId)
                .build()
        );

        productAdminMapper.postProductOutgoingStockAdmin(
                ProductOutgoingStock.builder()
                        .productOrderId(productOrderId)
                        .productId(productId)
                        .productSizeCategoryId(productSizeCategoryId)
                        .productOutgoingStockCount(productOrderCount)
                        .build()
        );
    }

    public List<GetProductOrdersResponseDto> getProductOrders(GetProductOrdersRequestDto getProductOrdersRequestDto) {
        int userId = getProductOrdersRequestDto.getUserId();
        List<ProductOrder> list = productOrderMapper.getProductOrders(userId);
        return list.stream().map(ProductOrder::toGetProductOrdersResponseDto).collect(Collectors.toList());
    }

    public GetProductOrderResponseDto getProductOrder(int productOrderId) {
        return productOrderMapper.getProductOrder(productOrderId).toGetProductOrderResponseDto();
    }

    public void deleteProductOrder(int productOrderId) {
        productOrderMapper.deleteProductOrder(productOrderId);
        productOrderDetailMapper.deleteProductOrder(productOrderId);
        productAdminMapper.deleteProductOutgoingStockAdmin(productOrderId);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteProductOrders(List<Integer> productOrderIds) {
        productOrderMapper.deleteProductOrders(productOrderIds);
        productOrderDetailMapper.deleteProductOrders(productOrderIds);
        productAdminMapper.deleteProductOutgoingStocksAdmin(productOrderIds);
    }

    public void putProductOrder(int productOrderId, PutProductOrderRequestDto putProductOrderRequestDto) {
        putProductOrderRequestDto.setProductOrderId(productOrderId);
        productOrderMapper.putProductOrder(putProductOrderRequestDto.toEntity());
        productAdminMapper.putProductOutgoingStockAdmin(ProductOutgoingStock
                .builder()
                .productOrderId(productOrderId)
                .productSizeCategoryId(putProductOrderRequestDto.getProductSizeCategoryId())
                .productOutgoingStockCount(putProductOrderRequestDto.getProductOrderCount())
                .build());
    }

}
