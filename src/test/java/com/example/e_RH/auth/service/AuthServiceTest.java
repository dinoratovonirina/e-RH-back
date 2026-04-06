package com.example.e_RH.auth.service;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;

import com.example.e_RH.auth.dto.AuthResponse;
import com.example.e_RH.auth.dto.LoginRequest;
import com.example.e_RH.auth.service.impl.IAuthenticationContext;
import com.example.e_RH.config.security.JwtUtils;
import com.example.e_RH.departement.entity.Departement;
import com.example.e_RH.role.entity.Role;
import com.example.e_RH.user.entity.User;
import com.example.e_RH.user.service.UserService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

        @Mock
        private UserService userService;

        @Mock
        private JwtUtils jwtUtils;

        @Mock
        private IAuthenticationContext iAuthenticationContext;

        @InjectMocks
        private AuthService authService;

        @Test
        void testLogin() {
                LoginRequest login = LoginRequest.builder()
                                .email("test@mail.com")
                                .password("123456")
                                .build();

                User user = new User(1L, "test@mail.com", "123456", "John", "Doe", true, new Role(), new Departement());
                AuthResponse authResponseMock = AuthResponse.builder()
                                .token("token")
                                .build();

                Authentication authentication = mock(Authentication.class);
                when(authentication.getPrincipal()).thenReturn(user);

                when(iAuthenticationContext.authenticate(login)).thenReturn(authentication);
                when(jwtUtils.generateToken(user.getEmail())).thenReturn(authResponseMock.token());

                AuthResponse authResponse = authService.login(login);

                assertNotNull(authResponse);
                assertEquals(authResponse.token(), authResponseMock.token());

                verify(jwtUtils).generateToken(user.getEmail());
        }
}
