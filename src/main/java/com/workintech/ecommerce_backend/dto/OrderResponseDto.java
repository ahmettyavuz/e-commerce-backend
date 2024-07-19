package com.workintech.ecommerce_backend.dto;

import com.workintech.ecommerce_backend.entity.*;

import java.time.Instant;
import java.util.List;

public record OrderResponseDto(
        Long id,

        Instant date,

        Enum_OrderStatus status,

        AddressResponseDto addressResponseDto,

        UserResponseDto userResponseDto,//Securitiden sonra güncellenecek

        Double amount,

        List<ProductResponseDto> productResponseDtos,

        PaymentResponseDto paymentResponseDto
) {
}
