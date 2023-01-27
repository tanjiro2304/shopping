package com.vn.treegridproject.service;

import com.vn.treegridproject.models.Category;
import com.vn.treegridproject.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category> getParentCategory(){
        return categoryRepo.getParentCategories();
    }


    public List<Category> getChildCategory(){
        return categoryRepo.getChildCategories();
    }

    public List<Category> getAllCategories(){
        return categoryRepo.getAllCategories();
    }
}
