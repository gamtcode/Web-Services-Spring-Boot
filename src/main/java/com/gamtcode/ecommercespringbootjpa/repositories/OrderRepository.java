package com.gamtcode.ecommercespringbootjpa.repositories;

import com.gamtcode.ecommercespringbootjpa.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
