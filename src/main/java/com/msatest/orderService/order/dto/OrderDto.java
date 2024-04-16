package com.msatest.orderService.order.dto;

import com.msatest.orderService.order.model.Orders;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    private Long id;
    private Long productId;
    private Long userId;

    public Orders toEntity(OrderDto orderDto) {
        return Orders.builder()
                .productId(orderDto.productId)
                .userId(orderDto.userId)
                .build();
    }

    public static OrderDto toDto(Orders orders) {
        return OrderDto.builder()
                .id(orders.getId())
                .productId(orders.getProductId())
                .userId(orders.getUserId())
                .build();
    }
}
