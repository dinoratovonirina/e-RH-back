package com.example.e_RH.departement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.e_RH.departement.entity.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Long> {
    Optional<Departement> findDepartementById(Long departementId);
}
