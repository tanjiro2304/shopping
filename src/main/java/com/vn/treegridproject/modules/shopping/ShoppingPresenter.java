package com.vn.treegridproject.modules.shopping;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vn.treegridproject.models.Category;
import com.vn.treegridproject.models.Product;
import com.vn.treegridproject.mvputils.BasePresenter;
import com.vn.treegridproject.mvputils.View;
import com.vn.treegridproject.service.CategoryService;
import com.vn.treegridproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@UIScope
@SpringComponent
public class ShoppingPresenter extends BasePresenter<ShoppingView> {



    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    public List<Category> getParentCategory(){
        return categoryService.getParentCategory();
    }

    public List<Category> getChildCategory(){
        return categoryService.getChildCategory();
    }


    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    public List<Product> getProductByCategoryId(Long id){
        return productService.getProductsByCategoryId(id);
    }

    public void setDataInGrid(Long id){
        getView().setProducts(getProductByCategoryId(id));
    }

}
