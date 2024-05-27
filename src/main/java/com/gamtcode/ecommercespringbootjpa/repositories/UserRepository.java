package com.gamtcode.ecommercespringbootjpa.repositories;

import com.gamtcode.ecommercespringbootjpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
