package com.msatest.orderService.order.dto;

import com.msatest.orderService.order.model.Orders;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    private Long id;
    private List<ProductOrderDto> productList;
    private Long userId;

//    public Orders toEntity(Long userId, ProductOrderDto productDto) {
//        return Orders.builder()
//                .productQuantity(productDto.getQuantity())
//                .productId(productDto.getProductId())
//                .userId(userId)
//                .build();
//    }

//    public static OrderDto toDto(Orders orders) {
//        return OrderDto.builder()
//                .id(orders.getId())
//                .productId(orders.getProductId())
//                .userId(orders.getUserId())
//                .build();
//    }
}
