package com.example.e_RH.departement.controller;

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

import com.example.e_RH.departement.entity.Departement;
import com.example.e_RH.departement.service.DepartementService;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class DepartementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartementService departementService;

    @Test
    void testGetAllDepartements() throws Exception {
        Departement d1 = new Departement(1L, "INFORMATIQUE");
        Departement d2 = new Departement(2L, "AUDITE");
        Departement d3 = new Departement(3L, "FORMATION ET DOCUMENTATION");

        when(departementService.getAllDepartement()).thenReturn(List.of(d1, d2, d3));

        mockMvc.perform(get("/department/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[2].departementName").value(d3.getDepartementName()));
    }
}
