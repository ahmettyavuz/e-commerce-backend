package com.workintech.ecommerce_backend.repository;

import com.workintech.ecommerce_backend.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
