package com.workintech.ecommerce_backend.controller;

import com.workintech.ecommerce_backend.dto.AddressRequestDto;
import com.workintech.ecommerce_backend.dto.AddressResponseDto;
import com.workintech.ecommerce_backend.dto.CreditCardRequestDto;
import com.workintech.ecommerce_backend.dto.CreditCardResponseDto;
import com.workintech.ecommerce_backend.dto.OrderRequestDto;
import com.workintech.ecommerce_backend.dto.OrderResponseDto;
import com.workintech.ecommerce_backend.entity.Address;
import com.workintech.ecommerce_backend.entity.CreditCard;
import com.workintech.ecommerce_backend.entity.Order;
import com.workintech.ecommerce_backend.mapper.AddressMapper;
import com.workintech.ecommerce_backend.mapper.CreditCardMapper;
import com.workintech.ecommerce_backend.mapper.OrderMapper;
import com.workintech.ecommerce_backend.service.AddressService;
import com.workintech.ecommerce_backend.service.CreditCardService;
import com.workintech.ecommerce_backend.service.OrderService;

import jakarta.validation.Valid;
import org.hibernate.boot.jaxb.SourceType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserController {

    private final OrderService orderService;
    private final AddressService addressService;
    private final CreditCardService creditCardService;

    public UserController(OrderService orderService, AddressService addressService, CreditCardService creditCardService) {
        this.orderService = orderService;
        this.addressService = addressService;
        this.creditCardService = creditCardService;
    }

    // Sipariş verme
    @PostMapping("/order")
    public OrderResponseDto saveOrder(@Valid @RequestBody OrderRequestDto orderRequestDto,
                                      Principal principal) {
        String user_mail =  principal.getName();
        Order order = orderService.addOrder(orderRequestDto, user_mail);
        return OrderMapper.orderToOrderResponseDto(order);
    }

    // Adres ekleme
    @PostMapping("/address")
    public AddressResponseDto saveAddress(@Valid @RequestBody AddressRequestDto addressRequestDto,
                                          Principal principal) {//otantikeyt olmayı isteyen alanalra request atarken kullanıcı bilgileri elimize her seferinde nereden geliyor
        String user_mail =  principal.getName();
        Address address = addressService.addAddress(addressRequestDto,user_mail);
        return AddressMapper.addressToAddressResponseDto(address);
    }

    // Kredi kartı ekleme
    @PostMapping("/credit-card")
    public CreditCardResponseDto saveCreditCard(@Valid @RequestBody CreditCardRequestDto creditCardRequestDto,
                                                Principal principal) {
        String user_mail =  principal.getName();
        CreditCard creditCard = creditCardService.addCreditCard(creditCardRequestDto, user_mail);
        return CreditCardMapper.creditCardToCreditCardResponseDto(creditCard);
    }

}

