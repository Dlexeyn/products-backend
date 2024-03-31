package com.dlexeyn.products.repository;

import com.dlexeyn.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findProductByArticle(String article);
}
