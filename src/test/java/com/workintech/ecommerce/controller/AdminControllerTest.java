package com.workintech.ecommerce.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workintech.ecommerce.config.SecurityConfig;
import com.workintech.ecommerce.dto.*;
import com.workintech.ecommerce.entity.*;
import com.workintech.ecommerce.service.CategoryService;
import com.workintech.ecommerce.service.ProductService;
import com.workintech.ecommerce.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@WebMvcTest(AdminController.class)
@Import(SecurityConfig.class) // Güvenlik konfigürasyon sınıfını dahil edin
class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @MockBean
    private UserService userService;

    @MockBean
    private CategoryService categoryService;

    @Autowired
    private ObjectMapper objectMapper;

    private ProductRequestDto productRequestDto;
    private UserBanRequestDto userBanRequestDto;
    private CategoryRequestDto categoryRequestDto;
    private Product product;
    private User user;
    private Category category;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        product = new Product();
        product.setId(1L);
        product.setName("Product");
        product.setPrice(100.0);

        user = new User();
        user.setId(1L);
        user.setEmail("user@example.com");

        category = new Category();
        category.setId(1L);
        category.setName(Enum_Category.AYAKKABI);

        productRequestDto = new ProductRequestDto("Product", "product", 100.00, 50, Enum_Gender.ERKEK, Enum_Category.KAZAK, new ArrayList<>());
        userBanRequestDto = new UserBanRequestDto(1L, "küfür");
        categoryRequestDto = new CategoryRequestDto(Enum_Category.AYAKKABI, "ayakkabı");
    }

    @Test
    @WithMockUser(authorities = "ADMİN")
    void createProduct() throws Exception {
        when(productService.createProduct(any(ProductRequestDto.class))).thenReturn(product);

        mockMvc.perform(MockMvcRequestBuilders.post("/admin/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productRequestDto)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(product.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(product.getName()));
    }

    @Test
    @WithMockUser(authorities = "ADMİN")
    void banUser() throws Exception {
        when(userService.banUser(any(UserBanRequestDto.class))).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.post("/admin/users/ban")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userBanRequestDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(user.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(user.getEmail()));
    }

    @Test
    @WithMockUser(authorities = "ADMİN")
    void createCategory() throws Exception {
        when(categoryService.save(any(Category.class))).thenReturn(category);

        mockMvc.perform(MockMvcRequestBuilders.post("/admin/category")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(categoryRequestDto)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(category.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(category.getName()));
    }

    @Test
    @WithMockUser(authorities = "ADMİN")
    void removeProduct() throws Exception {
        when(productService.delete(anyLong())).thenReturn(product);

        mockMvc.perform(MockMvcRequestBuilders.delete("/admin/product/{id}", 1L))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(product.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(product.getName()));
    }
}
