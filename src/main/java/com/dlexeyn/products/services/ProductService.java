package com.dlexeyn.products.services;

import com.dlexeyn.products.dto.ProductCreationDto;
import com.dlexeyn.products.dto.ProductDto;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    ProductDto createProduct(ProductCreationDto productDto);

    List<ProductDto> getAll();

    ProductDto getProductByID(UUID id);

    ProductDto updateProduct(UUID id, ProductCreationDto updatedProductDto);

    void deleteProduct(UUID id);
}
