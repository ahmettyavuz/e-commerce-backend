package com.workintech.ecommerce_backend.controller;

import com.workintech.ecommerce_backend.dto.ProductRequestDto;
import com.workintech.ecommerce_backend.dto.ProductResponseDto;
import com.workintech.ecommerce_backend.dto.UserBanRequestDto;
import com.workintech.ecommerce_backend.entity.Product;
import com.workintech.ecommerce_backend.mapper.ProductMapper;
import com.workintech.ecommerce_backend.service.ProductService;
import com.workintech.ecommerce_backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final ProductService productService;
    private final UserService userService;

    @Autowired
    public AdminController(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    // Ürün ekleme
    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDto createProduct(@Valid @RequestBody ProductRequestDto productRequestDto) {
        Product product = productService.createProduct(productRequestDto);
        return ProductMapper.productToProductResponseDto(product);
    }

    // Kullanıcı banlamak
    @PostMapping("/users/ban")
    public void banUser(@Valid @RequestBody UserBanRequestDto userBanRequestDto) {
        userService.banUser(userBanRequestDto.userId(), userBanRequestDto.reason());
    }

}
