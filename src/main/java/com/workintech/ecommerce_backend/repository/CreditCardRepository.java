package com.workintech.ecommerce_backend.repository;

import com.workintech.ecommerce_backend.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
