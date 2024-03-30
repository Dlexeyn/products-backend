package com.dlexeyn.products.dto;

import lombok.*;
import lombok.experimental.Accessors;


import java.util.UUID;

@Data
@Accessors(chain = true)
public class ProductDto {
    private UUID id;

    private String article;

    private String title;

    private String category;

    private Long price;

    private String createdAt;

    private String updatedAt;
}
