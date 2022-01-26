package com.example.jewete.repository;

import com.example.jewete.model.Role;
import com.example.jewete.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
