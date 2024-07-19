package com.workintech.ecommerce_backend.dto;

import com.workintech.ecommerce_backend.entity.Enum_Category;
import jakarta.validation.constraints.NotBlank;

public record CategoryResponseDto(Long id,
                          Enum_Category name,
                          String description) {

}
