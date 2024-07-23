package com.workintech.ecommerce_backend.dto;


public record AddressResponseDto(Long id,
                                 String description,
                                 String street,
                                 String neighborhood,
                                 String district,
                                 String city,
                                 String postalCode) {

}
