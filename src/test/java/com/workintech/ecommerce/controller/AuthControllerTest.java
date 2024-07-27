package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.dto.UserRegisterRequestDto;
import com.workintech.ecommerce.dto.UserResponseDto;
import com.workintech.ecommerce.entity.User;
import com.workintech.ecommerce.mapper.UserMapper;
import com.workintech.ecommerce.service.RegisterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthControllerTest {

    @Mock
    private RegisterService registerService;

    @InjectMocks
    private AuthController authController;

    private UserRegisterRequestDto userRegisterRequestDto;
    private UserResponseDto userResponseDto;

    @BeforeEach
    void setUp() {
        userRegisterRequestDto = new UserRegisterRequestDto(
                "John",
                "Doe",
                "john.doe@example.com",
                "password123"
        );

        userResponseDto = new UserResponseDto(
                "John",
                "Doe",
                "john.doe@example.com"
        );
    }

    @Test
    void register() {
        // Mock RegisterService to return a User object
        User mockUser = new User();
        mockUser.setFirstName(userRegisterRequestDto.firstName());
        mockUser.setLastName(userRegisterRequestDto.lastName());
        mockUser.setEmail(userRegisterRequestDto.email());
        mockUser.setPassword(userRegisterRequestDto.password()); // Ensure to set the password if needed

        when(registerService.register(
                userRegisterRequestDto.firstName(),
                userRegisterRequestDto.lastName(),
                userRegisterRequestDto.email(),
                userRegisterRequestDto.password()
        )).thenReturn(mockUser);

        // Mock UserMapper static methods
        try (MockedStatic<UserMapper> mockedMapper = mockStatic(UserMapper.class)) {
            mockedMapper.when(() -> UserMapper.userToUserResponseDto(mockUser)).thenReturn(userResponseDto);

            // Call the controller method
            UserResponseDto response = authController.register(userRegisterRequestDto);

            // Assert that the response is not null and has expected values
            assertNotNull(response);
            assertEquals(userResponseDto.firstName(), response.firstName());
            assertEquals(userResponseDto.lastName(), response.lastName());
            assertEquals(userResponseDto.email(), response.email());

            // Verify that registerService.register() and UserMapper.userToUserResponseDto() were called
            verify(registerService, times(1)).register(
                    userRegisterRequestDto.firstName(),
                    userRegisterRequestDto.lastName(),
                    userRegisterRequestDto.email(),
                    userRegisterRequestDto.password()
            );

            mockedMapper.verify(() -> UserMapper.userToUserResponseDto(mockUser), times(1));
        }
    }
}