package com.dlexeyn.products.controllers;

import com.dlexeyn.products.dto.ProductCreationDto;
import com.dlexeyn.products.dto.ProductDto;
import com.dlexeyn.products.dto.ProductUpdationDto;
import com.dlexeyn.products.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Validated
@RestController
@RequestMapping("/products")
@Tag(name = "Product", description = "Product management APIs")
public class ProductsController {

    private final ProductService productService;

    @Operation(summary = "Retrieve a Product by Id", description = "Get a ProductDto object by specifying its id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = ProductDto.class),
                    mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())})})
    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("id") UUID id) {
        ProductDto findProduct = productService.getProductByID(id);
        return new ResponseEntity<>(findProduct, HttpStatus.OK);
    }

    @Operation(summary = "Retrieve all products", description = "Get all product objects from database.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ProductDto.class)))}
            ),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())})
    })
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAll() {
        List<ProductDto> productDtos = productService.getAll();
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

    @Operation(summary = "Create a new product")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Product created successfully",
                    content = {
                            @Content(schema = @Schema(implementation = ProductDto.class), mediaType = "application/json")
                    }),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema())})
    })
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductCreationDto productDto) {
        ProductDto savedProduct = productService.createProduct(productDto);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @Operation(summary = "Update a product")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Product updated successfully",
                    content = {
                            @Content(schema = @Schema(implementation = ProductDto.class), mediaType = "application/json")
                    }),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", description = "Product not found",
                    content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema())})
    })
    @PutMapping("{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") UUID id, @Valid @RequestBody ProductUpdationDto updatedProductDto) {
        ProductDto updateProduct = productService.updateProduct(id, updatedProductDto);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    @Operation(summary = "Delete a product")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Product deleted successfully",
                    content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", description = "Product not found",
                    content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(schema = @Schema())})
    })
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") UUID id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
}
