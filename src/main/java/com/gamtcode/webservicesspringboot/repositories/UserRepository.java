package com.gamtcode.webservicesspringboot.repositories;

import com.gamtcode.webservicesspringboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
