package com.workintech.ecommerce_backend.repository;

import com.workintech.ecommerce_backend.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
