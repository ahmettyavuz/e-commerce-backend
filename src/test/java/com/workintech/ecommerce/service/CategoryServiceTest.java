package com.workintech.ecommerce.service;

import com.workintech.ecommerce.entity.Category;
import com.workintech.ecommerce.entity.Enum_Category;
import com.workintech.ecommerce.repository.CategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CategoryServiceTest {


    private final CategoryRepository categoryRepository;

    @Autowired
    CategoryServiceTest(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @DisplayName("Can find category by name")
    @Test
    void getByName() {
        Optional<Category> foundCategory = categoryRepository.getByName(Enum_Category.AYAKKABI);

        assertThat(foundCategory).isPresent();
        assertThat(foundCategory.get().getName()).isEqualTo(Enum_Category.AYAKKABI);
    }
}