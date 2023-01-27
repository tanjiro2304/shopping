package com.vn.treegridproject.modules.shopping;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.treegrid.TreeGrid;
import com.vaadin.flow.data.provider.hierarchy.HierarchicalDataProvider;
import com.vaadin.flow.function.SerializablePredicate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vn.treegridproject.models.Category;
import com.vn.treegridproject.models.Product;
import com.vn.treegridproject.mvputils.BaseView;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@UIScope
@SpringComponent
@Route("/shopping")
public class ShoppingView extends BaseView<ShoppingPresenter> {

    private TreeGrid<Category> categoryTreeGrid;

    private Grid<Product> productGrid;

    private VerticalLayout categoryTreeLayout;

    private VerticalLayout productGridLayout;

    private HorizontalLayout mainLayout;



    protected void init() {
        initializeTreeGrid();
        initializeTreeGridLayout();
        initializeProductGrid();
        initializeProductGridLayout();
        initializeMainLayout();

        add(mainLayout);
    }

    private void initializeMainLayout(){
        mainLayout = new HorizontalLayout();
        mainLayout.setSizeFull();
        mainLayout.add(categoryTreeLayout,productGridLayout);
    }

    private void initializeTreeGridLayout(){
        Div div = new Div(categoryTreeGrid);
        div.setSizeFull();
        categoryTreeLayout = new VerticalLayout();
        categoryTreeLayout.setHeightFull();
        categoryTreeLayout.setWidth(35, Unit.PERCENTAGE);
        categoryTreeLayout.add(div);
    }

    private void initializeProductGrid(){
        productGrid = new Grid<>();
        productGrid.addColumn(Product::getProductId).setHeader("Product Id");
        productGrid.addColumn(Product::getProductName).setHeader("Product Name");
    }

    public void setProducts(List<Product> products){
        this.productGrid.setItems(products);
    }

    private void initializeProductGridLayout(){
        productGridLayout = new VerticalLayout(productGrid);
    }

    private void initializeTreeGrid(){
        categoryTreeGrid = new TreeGrid<>();
        categoryTreeGrid.setItems(getPresenter().getParentCategory(), this::getChildCategory);
        categoryTreeGrid.addHierarchyColumn(Category::getName).setHeader("Category");
        categoryTreeGrid.addItemClickListener(item ->productGrid.setItems(getPresenter().
                getProductByCategoryId(item.getItem().
                        getId())));

    }

    public List<Category> getChildCategory(Category parent){

        return getPresenter().getChildCategory().
                stream().
                filter(category -> Objects.equals(category.getParent().getId(), parent.getId())).
                collect(Collectors.toList());
    }


}
