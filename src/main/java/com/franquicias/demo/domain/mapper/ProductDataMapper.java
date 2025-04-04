package com.franquicias.demo.domain.mapper;

import com.franquicias.demo.domain.dto.Product;
import com.franquicias.demo.infrastructure.entity.ProductEntity;

public class ProductDataMapper {
    public static ProductEntity fromProductToProductEntity(Product product){
        return ProductEntity.builder()
                .id(product.getId())
                .name(product.getName())
                .stock(product.getStock())
                .branchId(product.getBranchId())
                .build();
    }

    public static Product fromProductEntityToProduct(ProductEntity productEntity){
        return Product.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .stock(productEntity.getStock())
                .branchId(productEntity.getBranchId())
                .build();
    }
}
