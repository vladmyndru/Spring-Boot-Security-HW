package com.example.Spring_Boot_Security_HW.repository;

import com.example.Spring_Boot_Security_HW.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
