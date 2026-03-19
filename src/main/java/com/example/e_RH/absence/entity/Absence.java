package com.example.e_RH.absence.entity;

import java.time.LocalDate;

import com.example.e_RH.absence.enums.MissingStatusEnum;
import com.example.e_RH.absence.enums.MissingTypeEnum;
import com.example.e_RH.users.entity.User;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "absences")
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user_id;

    private LocalDate start_date;
    private LocalDate end_date;

    @Enumerated(EnumType.STRING)
    private MissingTypeEnum type;

    @Enumerated(EnumType.STRING)
    private MissingStatusEnum status;
}
