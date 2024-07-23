package com.workintech.ecommerce_backend.service;

import com.workintech.ecommerce_backend.dto.OrderRequestDto;
import com.workintech.ecommerce_backend.entity.Order;
import com.workintech.ecommerce_backend.entity.User;
import com.workintech.ecommerce_backend.mapper.OrderMapper;
import com.workintech.ecommerce_backend.repository.OrderRepository;
import com.workintech.ecommerce_backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;


    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
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

    @Transactional
    @Override
    public Order addOrder(OrderRequestDto orderRequestDto,String user_mail) {
        Optional<User> user = userRepository.findByEmail(user_mail);
        Order order = OrderMapper.orderRequestDtoToOrder(orderRequestDto);
        order.setUser(user.get());
        user.get().setAddOrder(order);
        userRepository.save(user.get());
        return save(order);
    }
}
