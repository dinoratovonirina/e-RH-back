package com.example.e_RH.role.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.e_RH.role.entity.Role;
import com.example.e_RH.role.enums.RoleTypeEnum;
import com.example.e_RH.role.repository.RoleRepository;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleService roleService;

    @Test
    void testGetRoleById() {
        Optional<Role> rowRole = Optional.ofNullable(new Role(1L, RoleTypeEnum.ADMIN));
        when(roleRepository.findById(1L)).thenReturn(rowRole);

        Optional<Role> role = roleService.getRoleById(1L);

        assertTrue(role.isPresent());
        assertEquals(RoleTypeEnum.ADMIN, role.get().getRoleName());
    }

    @Test
    void testGetRoleByName() {
        Optional<Role> rowRole = Optional.ofNullable(new Role(2L, RoleTypeEnum.EMPLOYEE));
        when(roleRepository.findByRoleName(RoleTypeEnum.EMPLOYEE)).thenReturn(rowRole);

        Optional<Role> role = roleService.getRoleByName(RoleTypeEnum.EMPLOYEE);

        assertTrue(role.isPresent());
        assertEquals(RoleTypeEnum.EMPLOYEE, role.get().getRoleName());
    }

    @Test
    void testGetAllRole() {
        Role r1 = new Role(1L, RoleTypeEnum.ADMIN);
        Role r2 = new Role(2L, RoleTypeEnum.MANAGER);
        Role r3 = new Role(3L, RoleTypeEnum.EMPLOYEE);

        when(roleRepository.findAll()).thenReturn(List.of(r1, r2, r3));

        List<Role> roles = roleService.getAllRole();

        assertEquals(3, roles.size());
        assertThat(roles).hasSize(3).extracting(Role::getRoleName).containsExactly(RoleTypeEnum.ADMIN,
                RoleTypeEnum.MANAGER, RoleTypeEnum.EMPLOYEE);
    }
}
