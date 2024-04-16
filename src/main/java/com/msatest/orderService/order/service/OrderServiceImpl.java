package com.msatest.orderService.order.service;

import com.msatest.orderService.order.dto.OrderDto;
import com.msatest.orderService.order.model.Orders;
import com.msatest.orderService.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public void createOrder(OrderDto orderDto) {
        orderRepository.save(orderDto.toEntity(orderDto));
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream().map(OrderDto::toDto).toList();
    }

    @Override
    public OrderDto getOrderById(Long orderId) {

        Orders orders = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        return OrderDto.toDto(orders);
    }

    @Override
    public List<OrderDto> getAllOrdersByUserId(Long userId) {
        return orderRepository.findAllByUserId(userId).stream().map(OrderDto::toDto).toList();
    }
}
