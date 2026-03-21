package com.example.e_RH.departement.service;

import org.springframework.stereotype.Service;

import com.example.e_RH.departement.entity.Departement;
import com.example.e_RH.departement.repository.DepartementRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartementService {
    private final DepartementRepository departementRepository;

    public Departement getDepartementById(Long departementId) {
        return this.departementRepository.getDepartementById(departementId);
    }
}
