package com.workintech.ecommerce.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "categories", schema = "fsweb")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(nullable = false, length = 45,name="name")
    @Enumerated(EnumType.STRING)
    private Enum_Category name;

    @Column(nullable = false,name="description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
    private List<Product> products = new ArrayList<>();

    // StackOverFlow hatasından dolayı toStringi ezmek zorunda kaldım bunu başka bir çözümü varmı. Spring toStringi nerede neden çağrıyor ve ne işe yarıyor.

    @Override
    public String toString() {
        Long var10000 = this.getId();
        return "Category(id=" + var10000 + ", name=" + this.getName() + ", description=" + this.getDescription() +")";
    }
}