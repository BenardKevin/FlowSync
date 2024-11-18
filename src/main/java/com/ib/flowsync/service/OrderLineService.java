package com.ib.flowsync.service;

import com.ib.flowsync.entity.OrderLine;
import com.ib.flowsync.repository.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineService {

    @Autowired
    OrderLineRepository orderLineRepository;

    public void createOrderLine(OrderLine orderLine) {
        orderLine.setId(null);
        orderLineRepository.save(orderLine);
    }

    public List<OrderLine> getAllOrderLine() {
        return (List<OrderLine>) orderLineRepository.findAll();
    }

    public OrderLine getOrderLineById(Integer orderLineId) {
        return orderLineRepository.findById(orderLineId).orElse(null);
    }

    public void updateOrderLine(OrderLine orderLine, Integer orderLineId) {
        orderLine.setId(orderLineId);
        orderLineRepository.save(orderLine);
    }

    public void deleteOrderLine(Integer orderLineId) {
        orderLineRepository.deleteById(orderLineId);
    }
}
