package com.example.e_RH.departement.service;

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

import com.example.e_RH.departement.entity.Departement;
import com.example.e_RH.departement.repository.DepartementRepository;

@ExtendWith(MockitoExtension.class)
public class DepartementServiceTest {

    @Mock
    private DepartementRepository departementRepository;

    @InjectMocks
    private DepartementService departementService;

    @Test
    void testGetDepartementById() {
        Optional<Departement> newDepartment = Optional.of(new Departement(1L, "INFORMATIQUE"));
        when(departementRepository.findById(1L)).thenReturn(newDepartment);

        Optional<Departement> department = departementService.getDepartementById(1L);

        assertTrue(department.isPresent());
        assertEquals(newDepartment.get(), department.get());
    }

    @Test
    void testGetAllDepartements() {
        Departement d1 = new Departement(1L, "INFORMATIQUE");
        Departement d2 = new Departement(2L, "AUDITE");
        Departement d3 = new Departement(3L, "FORMATION ET DOCUMENTATION");
        when(departementRepository.findAll()).thenReturn(List.of(d1, d2, d3));

        List<Departement> departements = departementService.getAllDepartement();

        assertThat(departements).hasSize(3).extracting(Departement::getDepartementName).contains("FORMATION ET DOCUMENTATION");
    }
}
