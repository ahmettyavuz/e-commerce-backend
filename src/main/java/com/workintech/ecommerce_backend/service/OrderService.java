package com.workintech.ecommerce_backend.service;


import com.workintech.ecommerce_backend.dto.OrderRequestDto;
import com.workintech.ecommerce_backend.entity.Order;

public interface OrderService extends Service<Order> {

    Order createOrder(OrderRequestDto orderRequestDto);
}
