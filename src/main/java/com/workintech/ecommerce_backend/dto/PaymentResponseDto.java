package com.workintech.ecommerce_backend.dto;

import com.workintech.ecommerce_backend.entity.CreditCard;
import com.workintech.ecommerce_backend.entity.Enum_PaymentMethod;
import com.workintech.ecommerce_backend.entity.Enum_PaymentStatus;

import java.time.Instant;

public record PaymentResponseDto(
        Long id,

        Enum_PaymentMethod method,

        Enum_PaymentStatus status,

        Instant date,

        Double amount,

        CreditCardResponseDto creditCardResponseDto
) {
}
