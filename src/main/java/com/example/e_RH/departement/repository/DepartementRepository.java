package com.example.e_RH.departement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.e_RH.departement.entity.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Long> {
    Departement getDepartementById(Long departementId);
}
