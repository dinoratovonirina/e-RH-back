package com.example.e_RH.role.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.e_RH.role.entity.Role;
import com.example.e_RH.role.enums.RoleTypeEnum;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(RoleTypeEnum roleName);
}
