package com.workintech.ecommerce_backend.dto;

import com.workintech.ecommerce_backend.entity.Enum_Gender;

import java.time.Instant;
import java.util.List;

public record ProductResponseDto(
        Long id,

        String name,

        String description,

        Double price,

        Double rating,

        Integer stockQuantity,

        Enum_Gender gender,

        Instant createdAt,
        CategoryResponseDto categoryResponseDto,
        List<ImageResponseDto> imageResponseDtos
) {
}
