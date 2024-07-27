package com.workintech.ecommerce.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workintech.ecommerce.dto.ProductResponseDto;
import com.workintech.ecommerce.entity.Enum_Category;
import com.workintech.ecommerce.entity.Enum_Gender;
import com.workintech.ecommerce.entity.Product;
import com.workintech.ecommerce.service.ProductService;
import com.workintech.ecommerce.mapper.ProductMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(WelcomeController.class)
public class WelcomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        // Setup işlemleri yapılabilir
    }

    @Test
    void getProducts() throws Exception {
        // Test verilerini hazırlayalım
        Product product1 = new Product();
        Product product2 = new Product();
        List<Product> products = Arrays.asList(product1, product2);

        ProductResponseDto dto1 = ProductMapper.productToProductResponseDto(product1);
        ProductResponseDto dto2 = ProductMapper.productToProductResponseDto(product2);
        List<ProductResponseDto> dtos = Arrays.asList(dto1, dto2);

        // ProductService'in getProducts methodunu mocklayalım
        when(productService.getProducts(0, 10)).thenReturn(products);

        // GET /welcome/ endpoint'ini test edelim
        mockMvc.perform(MockMvcRequestBuilders.get("/welcome/")
                        .param("offset", "0")
                        .param("count", "10"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(dtos)));
    }

    @Test
    void getByCategoryAndGender() throws Exception {
        // Test verilerini hazırlayalım
        Product product1 = new Product();
        Product product2 = new Product();
        List<Product> products = Arrays.asList(product1, product2);

        ProductResponseDto dto1 = ProductMapper.productToProductResponseDto(product1);
        ProductResponseDto dto2 = ProductMapper.productToProductResponseDto(product2);
        List<ProductResponseDto> dtos = Arrays.asList(dto1, dto2);

        // ProductService'in getByCategoryAndGender methodunu mocklayalım
        when(productService.getByCategoryAndGender(Enum_Category.AYAKKABI, Enum_Gender.ERKEK, 0, 10)).thenReturn(products);

        // GET /welcome/category/gender endpoint'ini test edelim
        mockMvc.perform(MockMvcRequestBuilders.get("/welcome/category/gender")
                        .param("name", Enum_Category.AYAKKABI.name())
                        .param("gender", Enum_Gender.ERKEK.name())
                        .param("offset", "0")
                        .param("count", "10"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(dtos)));
    }
}
