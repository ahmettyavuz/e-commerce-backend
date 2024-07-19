package com.workintech.ecommerce_backend.dto;

import com.workintech.ecommerce_backend.entity.Enum_Category;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;


public record CategoryRequestDto( @NotNull(message = "Category name cannot be null")
                                 Enum_Category name,
                                 @NotNull(message = "Category information cannot be null")
                                 String description) {
}
