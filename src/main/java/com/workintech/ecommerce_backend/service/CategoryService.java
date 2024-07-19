package com.workintech.ecommerce_backend.service;

import com.workintech.ecommerce_backend.entity.Category;


public interface CategoryService extends Service<Category> {
    Category getByName(String name);
}
