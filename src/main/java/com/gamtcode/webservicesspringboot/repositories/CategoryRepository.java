package com.gamtcode.webservicesspringboot.repositories;

import com.gamtcode.webservicesspringboot.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
