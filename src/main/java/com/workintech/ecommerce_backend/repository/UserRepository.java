package com.workintech.ecommerce_backend.repository;


import com.workintech.ecommerce_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
