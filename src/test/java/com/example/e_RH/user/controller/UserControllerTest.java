package com.example.e_RH.user.controller;

import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.e_RH.departement.entity.Departement;
import com.example.e_RH.role.entity.Role;
import com.example.e_RH.role.enums.RoleTypeEnum;
import com.example.e_RH.user.entity.User;
import com.example.e_RH.user.service.UserService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void testGetListUsers() throws Exception {
        User u1 = new User(1L, "rakoto@yahoo.fr", "123456", "rakoto", "koto", true,
                new Role(1L, RoleTypeEnum.ADMIN), new Departement());
        User u2 = new User(2L, "rakotovao@yahoo.fr", "123456", "rakotonoro", "noro", true,
                new Role(1L, RoleTypeEnum.ADMIN), new Departement());

        when(userService.getAllUsers()).thenReturn(List.of(u1, u2));

        mockMvc.perform(get("/user/list"))
                .andExpect(status().isOk());
    }
}
