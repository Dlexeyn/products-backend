package com.dlexeyn.products.dto;

import com.dlexeyn.products.util.UniqueArticle;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ProductCreationDto {
    @UniqueArticle
    @NotBlank(message = "The article is required.")
    private String article;

    @NotBlank(message = "The title is required.")
    private String title;

    @Size(min = 3, max = 100, message = "The category must be from 3 to 100 characters.")
    private String category;

    @NotNull(message = "The price is required.")
    @Min(value = 0, message = "The age must be equal or greater than 0")
    private Long price;
}
