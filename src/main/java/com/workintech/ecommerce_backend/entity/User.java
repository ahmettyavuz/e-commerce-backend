package com.workintech.ecommerce_backend.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users", schema = "fsweb")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(nullable = false, length = 45,name="first_name")
    private String firstName;

    @Column(nullable = false, length = 45,name="last_name")
    private String lastName;

    @Column(nullable = false, length = 45, unique = true,name="email")
    private String email;

    @Column(nullable = false, length = 45,name="password")
    private String password;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;


    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch=FetchType.LAZY)
    @JoinTable(name="user_credit_card",schema = "public",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="credit_card_id"))
    private List<CreditCard> creditCards;


    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch=FetchType.LAZY)
    @JoinTable(name="user_address",schema = "public",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="address_id"))
    private List<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Review> reviews ;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Order> orders ;

}
