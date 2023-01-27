package com.vn.treegridproject.repo;


import com.vn.treegridproject.models.Category;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CategoryRepo {

    private List<Category> allCategories;


    @PostConstruct
    public void initializeData(){
        allCategories = new ArrayList<>();
        Category electronics = new Category(1L,"Electronics", null);
        Category homeAppliances = new Category(2L,"Home Appliances", null);
        Category cloths = new Category(3L,"Cloths", null);

        Category laptop = new Category(11L,"Laptop", electronics);
        Category mobile = new Category(12L,"Mobile", electronics);
        Category accessories = new Category(13L,"Accessories", electronics);


        Category washingMachines = new Category(21L,"Washing Machine", homeAppliances);
        Category refrigerator = new Category(22L,"Refrigerator", homeAppliances);
        Category dishwasher = new Category(23L,"Dish Washer", homeAppliances);


        Category shirts = new Category(31L,"Shirts", cloths);
        Category tshirts = new Category(32L,"T-Shirts", cloths);
        Category bottomWear = new Category(33L,"Bottom Wear", cloths);

        allCategories.add(electronics);
        allCategories.add(cloths);
        allCategories.add(homeAppliances);
        allCategories.add(laptop);
        allCategories.add(mobile);
        allCategories.add(accessories);
        allCategories.add(washingMachines);
        allCategories.add(refrigerator);
        allCategories.add(dishwasher);
        allCategories.add(shirts);
        allCategories.add(tshirts);
        allCategories.add(bottomWear);

    }

    public List<Category> getAllCategories() {
        return allCategories;
    }

    public List<Category> getParentCategories(){
        return allCategories.stream().filter(category -> category.getParent() == null).collect(Collectors.toList());
    }

    public List<Category> getChildCategories(){
        return allCategories.stream().filter(category -> category.getParent() != null).collect(Collectors.toList());
    }
}
