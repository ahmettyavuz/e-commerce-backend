package com.workintech.ecommerce_backend.mapper;


import com.workintech.ecommerce_backend.dto.UserRegisterRequestDto;
import com.workintech.ecommerce_backend.dto.UserRequestDto;
import com.workintech.ecommerce_backend.dto.UserResponseDto;
import com.workintech.ecommerce_backend.entity.User;

public class UserMapper {

    public static User userRegisterRequestDtoToUser(UserRegisterRequestDto userRegisterRequestDto){
        User user = new User();
        user.setEmail(userRegisterRequestDto.email());
        user.setFirstName(userRegisterRequestDto.firstName());
        user.setLastName(userRegisterRequestDto.lastName());
        user.setPassword(userRegisterRequestDto.password());
        return user;
    }

    public static User userRequestDtoToUser(UserRequestDto userRequestDto){
         User user = new User();
         user.setEmail(userRequestDto.email());
         return user;
    }

    public static UserResponseDto userToUserResponseDto (User user) {
        return new UserResponseDto(user.getFirstName(),user.getLastName(),user.getEmail()) ;
    }


}
