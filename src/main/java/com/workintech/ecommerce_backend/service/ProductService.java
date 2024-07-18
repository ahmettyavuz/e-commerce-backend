package com.workintech.ecommerce_backend.service;

import com.workintech.ecommerce_backend.entity.Enum_Category;
import com.workintech.ecommerce_backend.entity.Product;

import java.util.List;

public interface ProductService extends Service<Product>{


    List<Product> getPriceDesc();
    List<Product> getPriceAsc();
    List<Product> getByName(String name);
    List<Product> getByCategory(Enum_Category category);

}
