package com.msatest.orderService.order.repository;

import com.msatest.orderService.order.dto.OrderCodeDto;
import com.msatest.orderService.order.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long>{

    List<Orders> findAllByUserId(Long userId);

    @Query("SELECT NEW com.msatest.orderService.order.dto.OrderCodeDto(o.orderCode) FROM Orders o WHERE o.userId = :userId GROUP BY o.orderCode")
    List<OrderCodeDto> findAllByUserIdGroupByOrderCode(@Param("userId") Long userId);

    List<Orders> findAllByOrderCode(String orderCode);
}
