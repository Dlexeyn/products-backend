package com.dlexeyn.products.services.impl;

import com.dlexeyn.products.dto.ProductCreationDto;
import com.dlexeyn.products.dto.ProductDto;
import com.dlexeyn.products.dto.ProductUpdationDto;
import com.dlexeyn.products.exception.InvalidArgumentException;
import com.dlexeyn.products.exception.ResourceNotFoundException;
import com.dlexeyn.products.mapper.ProductMapper;
import com.dlexeyn.products.model.Product;
import com.dlexeyn.products.repository.ProductRepository;
import com.dlexeyn.products.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductDto createProduct(ProductCreationDto productDto) {
        Product product = ProductMapper.mapToProduct(productDto);
        Product saveProduct = productRepository.save(product);
        return ProductMapper.mapToProductDto(saveProduct);
    }

    @Override
    public List<ProductDto> getAll() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductMapper::mapToProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductByID(UUID id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Product with id: " + id + " not found!"
                )

        );
        return ProductMapper.mapToProductDto(product);
    }

    @Override
    public ProductDto updateProduct(UUID id, ProductUpdationDto updatedProductDto) {
        Product productToUpdate = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Product to update with id: " + id + " is not Exist!"
                ));

        Product articleProduct = productRepository.findProductByArticle(updatedProductDto.getArticle());

        if(articleProduct.getId() != productToUpdate.getId()) {
            throw new InvalidArgumentException("Product with article: " + updatedProductDto.getArticle() +
                    " already exists!");
        }

        productToUpdate.setTitle(updatedProductDto.getTitle())
                .setPrice(updatedProductDto.getPrice())
                .setCategory(updatedProductDto.getCategory())
                .setArticle(updatedProductDto.getArticle());

        Product updatedProduct = productRepository.save(productToUpdate);

        return ProductMapper.mapToProductDto(updatedProduct);
    }

    @Override
    public void deleteProduct(UUID id) {
        Product productToDelete = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Product to delete with id: " + id + " is not Exist!"
                ));

        productRepository.deleteById(id);
    }
}
