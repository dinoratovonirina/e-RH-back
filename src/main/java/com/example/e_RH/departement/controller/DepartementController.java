package com.example.e_RH.departement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.e_RH.departement.entity.Departement;
import com.example.e_RH.departement.repository.DepartementRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("department")
@RequiredArgsConstructor
public class DepartementController {
    private final DepartementRepository departementRepository;

    @GetMapping("list")
    public ResponseEntity<List<Departement>> getAllDepartements() {
        return ResponseEntity.status(HttpStatus.OK).body(departementRepository.findAll());
    }
}
