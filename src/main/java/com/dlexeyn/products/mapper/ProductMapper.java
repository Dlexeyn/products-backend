package com.dlexeyn.products.mapper;

import com.dlexeyn.products.dto.ProductDto;
import com.dlexeyn.products.model.Product;

public class ProductMapper {
    public static ProductDto mapToProductDto(Product product){
        return new ProductDto()
                .setId(product.getId())
                .setArticle(product.getArticle())
                .setTitle(product.getTitle())
                .setPrice(product.getPrice())
                .setCategory(product.getCategory())
                .setCreatedAt(product.getCreatedAt())
                .setUpdatedAt(product.getUpdatedAt());
    }

    public static Product mapToProduct(ProductDto productDto){
        return new Product()
                .setId(productDto.getId())
                .setArticle(productDto.getArticle())
                .setTitle(productDto.getTitle())
                .setPrice(productDto.getPrice())
                .setCategory(productDto.getCategory())
                .setCreatedAt(productDto.getCreatedAt())
                .setUpdatedAt(productDto.getUpdatedAt());
    }

}
