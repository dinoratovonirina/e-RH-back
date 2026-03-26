package com.example.e_RH.role.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.e_RH.role.entity.Role;
import com.example.e_RH.role.enums.RoleTypeEnum;
import com.example.e_RH.role.service.RoleService;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class RoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoleService roleService;

    @Test
    void testGetAllRole() throws Exception {
        Role r1 = new Role(1L, RoleTypeEnum.ADMIN);
        Role r2 = new Role(2L, RoleTypeEnum.MANAGER);
        Role r3 = new Role(3L, RoleTypeEnum.EMPLOYEE);

        when(roleService.getAllRole()).thenReturn(List.of(r1, r2, r3));

        mockMvc.perform(get("/role/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1));
    }
}
