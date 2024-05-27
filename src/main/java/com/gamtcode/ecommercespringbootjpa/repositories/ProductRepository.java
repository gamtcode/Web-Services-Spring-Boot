package com.gamtcode.ecommercespringbootjpa.repositories;

import com.gamtcode.ecommercespringbootjpa.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
