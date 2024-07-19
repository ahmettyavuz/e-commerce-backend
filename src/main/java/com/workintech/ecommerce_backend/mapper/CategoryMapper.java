package com.workintech.ecommerce_backend.mapper;

import com.workintech.ecommerce_backend.dto.CategoryRequestDto;
import com.workintech.ecommerce_backend.dto.CategoryResponseDto;
import com.workintech.ecommerce_backend.entity.Category;

public class CategoryMapper {
    public static Category categoryRequestDtoToCategory(CategoryRequestDto categoryRequestDto){
        Category category = new Category();
        category.setName(categoryRequestDto.name());
        category.setDescription(categoryRequestDto.description());

        return category;
    }

    public static CategoryResponseDto categoryToCategoryResponseDto (Category category){
        return new CategoryResponseDto(category.getId(),category.getName(),category.getDescription());
    }
}
