package com.gamtcode.webservicesspringboot.repositories;

import com.gamtcode.webservicesspringboot.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
