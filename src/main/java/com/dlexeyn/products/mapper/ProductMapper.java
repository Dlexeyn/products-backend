package com.dlexeyn.products.mapper;

import com.dlexeyn.products.dto.ProductCreationDto;
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
                .setAmount(product.getAmount())
                .setDescription(product.getDescription())
                .setCreatedAt(product.getCreatedAt())
                .setUpdatedAt(product.getUpdatedAt());
    }

    public static Product mapToProduct(ProductCreationDto productDto){
        return new Product()
                .setArticle(productDto.getArticle())
                .setTitle(productDto.getTitle())
                .setPrice(productDto.getPrice())
                .setCategory(productDto.getCategory())
                .setAmount(productDto.getAmount())
                .setDescription(productDto.getDescription());
    }

}