package com.ib.flowsync.service;

import com.ib.flowsync.entity.Order;
import com.ib.flowsync.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public void createOrder(Order order) {
        order.setId(null);
        orderRepository.save(order);
    }

    public List<Order> getAllOrder() {
        return (List<Order>) orderRepository.findAll();
    }

    public Order getOrderById(Integer orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public void updateOrder(Order order, Integer orderId) {
        order.setId(orderId);
        orderRepository.save(order);
    }

    public void deleteOrder(Integer orderId) {
        orderRepository.deleteById(orderId);
    }
}
