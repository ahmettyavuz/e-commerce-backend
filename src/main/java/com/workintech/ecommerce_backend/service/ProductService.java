package com.workintech.ecommerce.service;

import com.workintech.ecommerce.entity.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService extends Service<Product>{


    List<Product> getPriceDesc();
    List<Product> getPriceAsc();
    List<Product> getByName(String name);
    List<Product> getByCategory(String name);
    List<Product> getByCategoryAndGender(String name, String gender,int offset,int count);
    List<Product> getProducts(int offset, int count);

}
