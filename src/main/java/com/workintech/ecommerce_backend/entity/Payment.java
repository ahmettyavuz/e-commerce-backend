package com.workintech.ecommerce_backend.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@Entity
@Table(name = "payments", schema = "fsweb")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(nullable = false, length = 20,name="method")
    @Enumerated(EnumType.STRING)
    private Enum_PaymentMethod method;

    @Column(nullable = false, length = 20,name="status")
    @Enumerated(EnumType.STRING)
    private Enum_PaymentStatus status;

    @Column(nullable = false,name="date")
    @Temporal(TemporalType.TIMESTAMP)
    private Instant date = Instant.now();

    @Column(nullable = false,name="amount")
    private Double amount;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "order_id", nullable = false, unique = true)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "credit_card_id")
    private CreditCard creditCard;

}