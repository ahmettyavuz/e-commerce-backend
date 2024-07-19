package com.workintech.ecommerce_backend.dto;

import jakarta.validation.Valid;

public record PaymentRequestDto (@Valid
                                CreditCardRequestDto creditCardRequestDto) {
}
