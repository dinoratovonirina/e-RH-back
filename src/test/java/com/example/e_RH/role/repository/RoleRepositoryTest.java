package com.example.e_RH.role.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.e_RH.role.entity.Role;
import com.example.e_RH.role.enums.RoleTypeEnum;

@DataJpaTest
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void testFindByRoleName() {
        Optional<Role> role = roleRepository.findByRoleName(RoleTypeEnum.ADMIN);

        assertTrue(role.isPresent());
        assertEquals(RoleTypeEnum.ADMIN, role.get().getRoleName());
    }

    @Test
    void testFindAllRole() {
        List<Role> roles = roleRepository.findAll();

        assertEquals(3, roles.size());
    }
}
