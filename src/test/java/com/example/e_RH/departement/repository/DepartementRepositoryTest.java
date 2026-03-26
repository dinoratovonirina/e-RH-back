package com.example.e_RH.departement.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.e_RH.departement.entity.Departement;

@DataJpaTest
public class DepartementRepositoryTest {
    
    @Autowired
    private DepartementRepository departementRepository;

    @Test
    void getDepartementById() {
        Optional<Departement> department = departementRepository.findById(1L);

        assertEquals(1, department.get().getId());
        assertEquals("INFORMATIQUE", department.get().getDepartementName());
    }
}
