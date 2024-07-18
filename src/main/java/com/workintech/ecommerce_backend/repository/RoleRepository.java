package com.workintech.ecommerce_backend.repository;

import com.workintech.ecommerce_backend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
