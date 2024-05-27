package com.gamtcode.ecommercespringbootjpa.repositories;

import com.gamtcode.ecommercespringbootjpa.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
