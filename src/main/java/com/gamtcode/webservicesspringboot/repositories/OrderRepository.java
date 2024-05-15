package com.gamtcode.webservicesspringboot.repositories;

import com.gamtcode.webservicesspringboot.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
