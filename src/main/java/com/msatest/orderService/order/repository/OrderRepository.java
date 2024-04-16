package com.msatest.orderService.order.repository;

import com.msatest.orderService.order.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long>{

    List<Orders> findAllByUserId(Long userId);
}
