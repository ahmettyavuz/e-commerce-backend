package com.workintech.ecommerce_backend.mapper;

import com.workintech.ecommerce_backend.dto.ProductRequestDto;
import com.workintech.ecommerce_backend.dto.ProductResponseDto;
import com.workintech.ecommerce_backend.entity.Product;

import java.util.stream.Collectors;

public class ProductMapper {

    public static Product productRequestDtoToProduct(ProductRequestDto productRequestDto){
        Product product = new Product();
        product.setName(productRequestDto.name());
        product.setDescription(productRequestDto.description());
       // product.setCategory(productRequestDto.category());
        // product.setImages( productRequestDto.imageRequestDto().stream().map(ImageMapper::imageRequestDtoToImage).toList());
       // product.setImages( productRequestDto.imageRequestDto().stream().map( item -> ImageMapper.imageRequestDtoToImage(item)).collect(Collectors.toList()) );
        product.setPrice(productRequestDto.price());
        product.setStockQuantity(productRequestDto.stockQuantity());
        product.setGender(productRequestDto.gender());
        return product;
    }

    public static ProductResponseDto productToProductResponseDto (Product product) {
     return new ProductResponseDto(product.getId(), product.getName(), product.getDescription(),
                              product.getPrice(),product.getRating(),product.getStockQuantity(),
                              product.getGender(),product.getCreatedAt(),CategoryMapper.categoryToCategoryResponseDto(product.getCategory()),
                              product.getImages().stream().map(ImageMapper::imageToImageResponseDto).toList());
    }
}
