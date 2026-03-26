package com.example.e_RH.auth.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.e_RH.auth.dto.RegisterRequest;
import com.example.e_RH.auth.factory.IUserFactory;
import com.example.e_RH.departement.entity.Departement;
import com.example.e_RH.departement.service.DepartementService;
import com.example.e_RH.role.entity.Role;
import com.example.e_RH.role.enums.RoleTypeEnum;
import com.example.e_RH.role.service.RoleService;
import com.example.e_RH.user.entity.User;
import com.example.e_RH.user.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class RegistrationServiceTest {

    @Mock
    private IUserFactory userFactory;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleService roleService;

    @Mock
    private DepartementService departementService;

    @InjectMocks
    private RegistrationService registrationService;

    @Test
    void should_register_user_with_role_and_departement() {

        RegisterRequest request = RegisterRequest.builder()
                .email("test@mail.com")
                .password("123456")
                .firstName("John")
                .lastName("Doe")
                .isActive(true)
                .roleId(3L)
                .departementId(3L)
                .build();

        Role role = new Role(3L, RoleTypeEnum.EMPLOYEE);
        Departement departement = new Departement(3L, "FORMATION ET DOCUMENTATION");
        User user = new User(1L, "test@mail.com", "123456", "John", "Doe", true, role, departement);

        when(roleService.getRoleById(3L)).thenReturn(Optional.of(role));
        when(departementService.getDepartementById(3L)).thenReturn(Optional.of(departement));
        when(userFactory.create(request, role, departement)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);

        User result = registrationService.register(request);

        assertNotNull(result);
        assertEquals("test@mail.com", result.getEmail());

        verify(roleService).getRoleById(3L);
        verify(departementService).getDepartementById(3L);
        verify(userFactory).create(request, role, departement);
        verify(userRepository).save(user);
    }
}