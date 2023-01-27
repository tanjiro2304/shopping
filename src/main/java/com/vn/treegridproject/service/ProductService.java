package com.vn.treegridproject.service;

import com.vn.treegridproject.models.Product;
import com.vn.treegridproject.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
    public List<Product> getProductsByCategoryId(Long id){
        if(id == null){
            throw new NullPointerException("Id cannot be null");
        }
        if(id < 10L){
            return productRepo.getAllProducts().stream().
                    filter(product -> Objects.equals(product.getCategoryId(), id)).
                    collect(Collectors.toList());
        }
        return productRepo.getAllProducts().stream().
                filter(product -> Objects.equals(product.getSubCategoryId(), id)).
                collect(Collectors.toList());
    }
}
