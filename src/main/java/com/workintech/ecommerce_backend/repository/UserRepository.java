package com.workintech.ecommerce_backend.repository;


import com.workintech.ecommerce_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value="SELECT u FROM User u WHERE u.email= :email")
    Optional<User> findByEmail(String email);

}
