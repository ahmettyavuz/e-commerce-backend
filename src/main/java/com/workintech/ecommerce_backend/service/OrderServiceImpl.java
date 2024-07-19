package com.workintech.ecommerce_backend.service;

import com.workintech.ecommerce_backend.dto.OrderRequestDto;
import com.workintech.ecommerce_backend.entity.Order;
import com.workintech.ecommerce_backend.entity.User;
import com.workintech.ecommerce_backend.mapper.OrderMapper;
import com.workintech.ecommerce_backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;


    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, UserService userService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
    }


    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(null) ;
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order delete(Long id) {
        Order order = findById(id);
        orderRepository.delete(order);
        return order;
    }

    @Override
    public Order createOrder(OrderRequestDto orderRequestDto) {
        User user = userService.findByEmail(orderRequestDto.userRequestDto().email());
        Order order = OrderMapper.orderRequestDtoToOrder(orderRequestDto);
        order.setUser(user);
        return order;
    }
}
