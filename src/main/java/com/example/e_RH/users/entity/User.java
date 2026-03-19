package com.example.e_RH.users.entity;

import com.example.e_RH.Role.entity.Role;
import com.example.e_RH.departement.entity.Departement;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name ="users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isActive;

    @ManyToOne
    private Role role;

    @ManyToOne
    private Departement department;
}
