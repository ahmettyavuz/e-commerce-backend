package com.workintech.ecommerce_backend.dto;

import jakarta.validation.constraints.*;

public record CreditCardResponseDto(
        String no,
        String name,
        Integer expireMonth,
        Integer expireYear,
        Integer ccv) {
}
