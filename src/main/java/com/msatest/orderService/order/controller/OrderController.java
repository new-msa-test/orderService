package com.msatest.orderService.order.controller;

import com.msatest.orderService.order.dto.OrderDto;
import com.msatest.orderService.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-service/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderDto orderDto) {

        orderService.createOrder(orderDto);

        return ResponseEntity.ok("주문 성공!");
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {

        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long orderId) {

        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<List<OrderDto>> getAllOrdersByUser(@PathVariable Long userId) {

        return ResponseEntity.ok(orderService.getAllOrdersByUserId(userId));
    }
}
