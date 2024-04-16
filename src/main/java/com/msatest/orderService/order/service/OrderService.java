package com.msatest.orderService.order.service;

import com.msatest.orderService.order.dto.OrderDto;
import com.msatest.orderService.order.dto.OrderListResponseDto;

import java.util.List;

public interface OrderService {
    void createOrder(OrderDto orderDto);

//    List<OrderDto> getAllOrders();

//    OrderDto getOrderById(Long orderId);

    List<OrderListResponseDto> getAllOrdersByUserId(Long userId);
}
