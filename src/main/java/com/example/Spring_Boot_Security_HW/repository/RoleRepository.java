package com.example.Spring_Boot_Security_HW.repository;

import com.example.Spring_Boot_Security_HW.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
