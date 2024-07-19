package com.workintech.ecommerce_backend.mapper;

import com.workintech.ecommerce_backend.dto.ImageRequestDto;
import com.workintech.ecommerce_backend.dto.ImageResponseDto;
import com.workintech.ecommerce_backend.entity.Image;

public class ImageMapper {

    public static Image imageRequestDtoToImage(ImageRequestDto imageRequestDto){
        Image image = new Image();
        image.setUrl(imageRequestDto.url());
        return image;
    }

    public static ImageResponseDto imageToImageResponseDto(Image image){
        return new ImageResponseDto(image.getId(), image.getUrl());
    }

}
