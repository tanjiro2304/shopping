package com.vn.treegridproject.repo;

import com.vn.treegridproject.models.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepo {
    List<Product> allProducts;

    @PostConstruct
    public void initializeData() {
        allProducts = new ArrayList<>();
        allProducts.addAll(Arrays.asList(
                Product.builder().
                        productId(123L).
                        productName("Asus Zenbook").
                        categoryId(1L).
                        subCategoryId(11L).
                        build(),
                Product.builder().
                        productId(124L).
                        productName("HP Pavillian G6").
                        categoryId(1L).
                        subCategoryId(11L).
                        build(),
                Product.builder().
                        productId(125L).
                        productName("Samsung Galaxy F23 5G").
                        categoryId(1L).
                        subCategoryId(12L).
                        build(),
                Product.builder().
                        productId(126L).
                        productName("Samsung Galaxy S22").
                        categoryId(1L).
                        subCategoryId(12L).
                        build(),
                Product.builder().
                        productId(127L).
                        productName("Apple Iphone").
                        categoryId(1L).
                        subCategoryId(12L).
                        build(),
                Product.builder().
                        productId(128L).
                        productName("Macbook Pro").
                        categoryId(1L).
                        subCategoryId(11L).
                        build()
        ));
    }

    public List<Product> getAllProducts() {
        return allProducts;
    }
}
