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
public class ProductOrderDto {
    private Long productId;
    private int quantity;

    public Orders toEntity(Long userId, String orderCode,ProductOrderDto productDto) {
    return Orders.builder()
            .orderCode(orderCode)
            .productQuantity(productDto.getQuantity())
            .productId(productDto.getProductId())
            .userId(userId)
            .build();
    }

    public static ProductOrderDto toDto(Orders orders) {
        return ProductOrderDto.builder()
                .productId(orders.getProductId())
                .quantity(orders.getProductQuantity())
                .build();
    }

}
