package com.example.e_RH.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.e_RH.role.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleById(Long roleId);
}
