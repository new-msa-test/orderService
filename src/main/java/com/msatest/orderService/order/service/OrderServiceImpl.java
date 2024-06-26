package com.msatest.orderService.order.service;

import com.msatest.orderService.order.dto.OrderCodeDto;
import com.msatest.orderService.order.dto.OrderDto;
import com.msatest.orderService.order.dto.OrderListResponseDto;
import com.msatest.orderService.order.dto.ProductOrderDto;
import com.msatest.orderService.order.model.Orders;
import com.msatest.orderService.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.hibernate.internal.util.collections.ArrayHelper.forEach;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public void createOrder(OrderDto orderDto) {

        String orderCode = "O" + generateUniqueID();

        orderDto.getProductList().forEach(productDto -> {
            Orders orders = productDto.toEntity(orderDto.getUserId(), orderCode,productDto);
            orderRepository.save(orders);
        });
    }

    public static String generateUniqueID() {
        // 현재 날짜 및 시간을 yyyyMMddHHmm 형식으로 포맷
        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = now.format(DateTimeFormatter.ofPattern("yyMMddHHmm"));

        // 100000 ~ 999999 사이의 난수 생성
        int randomNumber = new Random().nextInt(900000) + 100000;

        // 현재 날짜시간과 6자리 난수를 조합하여 Unique ID 생성
        return formattedDateTime + "-" + randomNumber;
    }

//    @Override
//    public List<OrderDto> getAllOrders() {
//        return orderRepository.findAll().stream().map(OrderDto::toDto).toList();
//    }

//    @Override
//    public OrderDto getOrderById(Long orderId) {
//
//        Orders orders = orderRepository.findById(orderId)
//                .orElseThrow(() -> new RuntimeException("Order not found"));
//
//        return OrderDto.toDto(orders);
//    }

    @Override
    public List<OrderListResponseDto> getAllOrdersByUserId(Long userId) {

        List<OrderCodeDto> orders = orderRepository.findAllByUserIdGroupByOrderCode(userId);

        List<OrderListResponseDto> result = new ArrayList<>();

        orders.forEach(orderCodeDto -> {
            List<ProductOrderDto> productOrderList = orderRepository.findAllByOrderCode(orderCodeDto.getOrderCode())
                    .stream()
                    .map(ProductOrderDto::toDto)
                    .toList();

            result.add(OrderListResponseDto.builder()
                    .orderCode(orderCodeDto.getOrderCode())
                    .productOrderList(productOrderList)
                    .build());
        });

        return result;
    }
}
