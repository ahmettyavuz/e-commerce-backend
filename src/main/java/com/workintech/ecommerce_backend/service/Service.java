package com.workintech.ecommerce_backend.service;

import java.util.List;

public interface Service<T> {
    List<T> findAll();
    T findById(Long id);
    T save(T object);
    T delete(Long id);
}
