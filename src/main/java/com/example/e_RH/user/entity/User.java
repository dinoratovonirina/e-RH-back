package com.example.e_RH.user.entity;

import com.example.e_RH.departement.entity.Departement;
import com.example.e_RH.role.entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @JsonProperty("isActive")
    private Boolean isActive;

    @JsonIgnore
    @ManyToOne(optional = true)
    @JoinColumn(nullable = true)
    private Role role;

    @JsonIgnore
    @ManyToOne(optional = true)
    @JoinColumn(nullable = true)
    private Departement departement;
}
