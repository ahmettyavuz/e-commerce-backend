package com.workintech.ecommerce_backend.service;


import com.workintech.ecommerce_backend.dto.AddressRequestDto;
import com.workintech.ecommerce_backend.entity.Address;

public interface AddressService extends Service<Address>{
    Address addAddress(AddressRequestDto addressRequestDto, String user_mail);
}
