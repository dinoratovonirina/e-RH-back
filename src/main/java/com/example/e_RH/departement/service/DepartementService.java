package com.example.e_RH.departement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.e_RH.departement.entity.Departement;
import com.example.e_RH.departement.repository.DepartementRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartementService {
    private final DepartementRepository departementRepository;

    public Optional<Departement> getDepartementById(Long departementId) {
        return departementRepository.findById(departementId);
    }
    
    public List<Departement> getAllDepartement() {
        return departementRepository.findAll();
    }
}
