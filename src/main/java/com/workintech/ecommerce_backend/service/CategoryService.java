package com.workintech.ecommerce_backend.service;

import com.workintech.ecommerce_backend.entity.Category;
import com.workintech.ecommerce_backend.entity.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryService extends Service<Category>{
    Category getByName(String name);
}
