package com.dlexeyn.products.util;

import com.dlexeyn.products.model.Product;
import com.dlexeyn.products.repository.ProductRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueArticleValidator implements ConstraintValidator<UniqueArticle, String> {

    private final ProductRepository productRepository;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Product findedProduct = productRepository.findProductByArticle(s);
        return findedProduct == null;
    }
}
