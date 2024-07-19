package com.workintech.ecommerce_backend.repository;

import com.workintech.ecommerce_backend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query("SELECT r FROM Role r WHERE r.role= :role")
    Optional<Role> findByAuthority(String role);
}
