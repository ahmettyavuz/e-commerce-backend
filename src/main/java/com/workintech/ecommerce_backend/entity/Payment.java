package com.workintech.ecommerce_backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments",schema = "fsweb")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String method;

    @Column(nullable = false, updatable = false, insertable = false)
    private Instant date;

    private Double amount;

    @ManyToOne
    @JoinColumn(name = "order_id", unique = true, nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "credit_card_id")
    private CreditCard creditCard;
}

