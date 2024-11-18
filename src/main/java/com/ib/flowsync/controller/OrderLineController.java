package com.ib.flowsync.controller;

import com.ib.flowsync.entity.OrderLine;
import com.ib.flowsync.service.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/orders")
public class OrderLineController {

    @Autowired
    OrderLineService orderLineService;

    @PutMapping("/{orderLineId}")
    public ResponseEntity<String> updateOrder(
            @PathVariable(value = "orderLineId") Integer orderLineId,
            @RequestBody OrderLine orderLine
    ) {
        orderLineService.updateOrderLine(orderLine, orderLineId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Order line update was successful");
    }
}
