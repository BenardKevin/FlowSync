package com.ib.flowsync.controller;

import com.ib.flowsync.entity.Order;
import com.ib.flowsync.entity.OrderLine;
import com.ib.flowsync.service.OrderLineService;
import com.ib.flowsync.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderLineService orderLineService;

    @PostMapping("")
    public ResponseEntity<String> createOrder(
            @RequestBody Order order
    ) {
        orderService.createOrder(order);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Order creation was successful");
    }

    @GetMapping("")
    public List<Order> getAllOrder() {
        return orderService.getAllOrder();
    }

    @GetMapping("/{orderId}")
    public @ResponseBody Order getOrderById(
            @PathVariable(value = "orderId") Integer orderId
    ) throws ResponseStatusException {
        Order order = orderService.getOrderById(orderId);

        if (order == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found");

        return order;
    }

    @GetMapping("/{orderId}/lines/{orderLineId}")
    public @ResponseBody OrderLine getOrderLineById(
            @PathVariable(value = "orderId") Integer orderId,
            @PathVariable(value = "orderLineId") Integer orderLineId
    ) throws ResponseStatusException {
        OrderLine orderline = orderLineService.getOrderLineById(orderLineId);

        if (orderline == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order line not found");

        return orderline;
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<String> updateOrder(
            @PathVariable(value = "orderId") Integer orderId,
            @RequestBody Order order
    ) {
        orderService.updateOrder(order, orderId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Order update was successful");
    }

    @DeleteMapping("/{orderId}")
    public @ResponseBody void deleteOrder(
            @PathVariable(value = "orderId") Integer orderId
    ) {
        orderService.deleteOrder(orderId);
    }

    @DeleteMapping("/{orderId}/lines/{orderLineId}")
    public @ResponseBody void deleteOrderLine(
            @PathVariable(value = "orderId") Integer orderId,
            @PathVariable(value = "orderLineId") Integer orderLineId,
            @RequestBody Order order
    ) {
        // TODO
    }
}
