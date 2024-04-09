package com.project.pet.repository.admin;

import com.project.pet.entity.product.Product;
import com.project.pet.entity.product.ProductIncomingStock;
import com.project.pet.entity.product.ProductOutgoingStock;
import com.project.pet.entity.product.ProductStock;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductAdminMapper {
    public int postProductAdmin(Product product);

    public Product getProductAdmin(int productId);

    public List<Product> getProductsAdmin();

    public int deleteProductAdmin(int productId);

    public int putProductAdmin(Product product);

    public int deleteProductsAdmin(List<Integer> productIds);

    public int postProductIncomingStock(ProductIncomingStock productIncomingStock);

    public List<ProductIncomingStock> getProductIncomingStocks();

    public int deleteProductIncomingStock(int productIncomingStockId);

    public int deleteProductIncomingStocksAdmin(List<Integer> productIncomingStockIds);

    public int putProductIncomingStockAdmin(ProductIncomingStock productIncomingStock);

    public int postProductStockAdmin(ProductStock productStock);

    public List<ProductStock> getProductStocksAdmin();

    public int deleteProductStockAdmin(int productStockId);

    public int deleteProductStocksAdmin(List<Integer> productStockIds);

    public int putProductStockAdmin(ProductStock productStock);

    public int postProductOutgoingStockAdmin(ProductOutgoingStock productOutgoingStock);

    public List<ProductOutgoingStock> getProductOutgoingStocksAdmin();

    public int deleteProductOutgoingStockAdmin(int productOutgoingStockId);

    public int deleteProductOutgoingStocksAdmin(List<Integer> productOutgoingStockIds);

    public int putProductOutgoingStockAdmin(ProductOutgoingStock productOutgoingStock);
}
