package com.dlexeyn.products.util;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueArticleValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueArticle {
    String message() default "Article must be unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
