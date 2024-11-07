package com.msatest.orderService.order.dto;

import com.msatest.orderService.order.model.Orders;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OrderDto {
    private Long id;
    private String orderCode;
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
//                .productList(orders.)
//                .userId(orders.getUserId())
//                .build();
//    }
}
