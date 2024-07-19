package com.workintech.ecommerce_backend.repository;


import com.workintech.ecommerce_backend.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
