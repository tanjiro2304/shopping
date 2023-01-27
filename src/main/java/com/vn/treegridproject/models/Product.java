package com.vn.treegridproject.models;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    private Long productId;
    private String productName;
    private Long categoryId;

    private Long subCategoryId;

}
