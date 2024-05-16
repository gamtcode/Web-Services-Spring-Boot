package com.gamtcode.webservicesspringboot.repositories;

import com.gamtcode.webservicesspringboot.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
