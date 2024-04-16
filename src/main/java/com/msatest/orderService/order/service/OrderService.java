package com.msatest.orderService.order.service;

import com.msatest.orderService.order.dto.OrderDto;

import java.util.List;

public interface OrderService {
    void createOrder(OrderDto orderDto);

//    List<OrderDto> getAllOrders();

//    OrderDto getOrderById(Long orderId);

//    List<OrderDto> getAllOrdersByUserId(Long userId);
}
