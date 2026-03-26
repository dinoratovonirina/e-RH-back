package com.example.e_RH.auth.controller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.e_RH.auth.dto.AuthResponse;
import com.example.e_RH.auth.dto.LoginRequest;
import com.example.e_RH.auth.dto.RegisterRequest;
import com.example.e_RH.auth.service.AuthService;
import com.example.e_RH.auth.service.RegistrationService;
import com.example.e_RH.departement.entity.Departement;
import com.example.e_RH.role.entity.Role;
import com.example.e_RH.role.enums.RoleTypeEnum;
import com.example.e_RH.user.entity.User;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthService authService;

    @MockBean
    private RegistrationService registrationService;

    @Test
    void testLogin() throws Exception {
        String json = """
                {
                    "email": "test@gmail.com",
                    "password": "123456"
                }
                """;

        AuthResponse authResponse = AuthResponse.builder()
                .token("token")
                .build();

        when(authService.login(any(LoginRequest.class))).thenReturn(authResponse);

        mockMvc.perform(post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value("token"));
    }

    @Test
    void testRegister() throws Exception {
        String json = """
                {
                    "email": "rakotondrinacyck@gmail.com",
                    "password": "123456",
                    "firstName": "RAKOTONDRINA",
                    "lastName": "Cyck",
                    "isActive": false,
                    "roleId": 2
                }
                """;

        User user = new User(1L, "rakotondrinacyck@mail.com", "123456", "RAKOTONDRINA", "Cyck", false,
                new Role(2L, RoleTypeEnum.MANAGER), new Departement());

        when(registrationService.register(any(RegisterRequest.class))).thenReturn(user);

        mockMvc.perform(post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.email").value("rakotondrinacyck@mail.com"));
    }
}
