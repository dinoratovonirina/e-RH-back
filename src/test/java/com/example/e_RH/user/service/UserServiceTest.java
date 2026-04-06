package com.example.e_RH.user.service;

import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.e_RH.departement.entity.Departement;
import com.example.e_RH.role.entity.Role;
import com.example.e_RH.role.enums.RoleTypeEnum;
import com.example.e_RH.user.entity.User;
import com.example.e_RH.user.repository.UserRepository;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testGetUserByEmail() {
        // Arrange
        User userMock = new User((long) 1, "rakoto@yahoo.fr", "123456", "rakoto", "koto", true,
                new Role((long) 1, RoleTypeEnum.ADMIN), new Departement());

        // Act
        when(userRepository.findByEmailAndIsActiveTrue("rakoto@yahoo.fr")).thenReturn(Optional.of(userMock));

        Optional<User> user = userService.getUserByEmail("rakoto@yahoo.fr");

        // Assertion
        assertThat(user).contains(userMock).as(userMock.getEmail());
    }

    @Test
    void testGetAllUsers() {
        User u1 = new User((long) 1, "rakoto@yahoo.fr", "123456", "rakoto", "koto", true,
                new Role((long) 1, RoleTypeEnum.ADMIN), new Departement());
        User u2 = new User((long) 2, "rakotovao@yahoo.fr", "123456", "rakotonoro", "noro", true,
                new Role((long) 1, RoleTypeEnum.ADMIN), new Departement());

        when(userRepository.findAll()).thenReturn(List.of(u1, u2));

        List<User> users = userService.getAllUsers();

        assertThat(users).hasSize(2).containsExactly(u1, u2);
    }
}
