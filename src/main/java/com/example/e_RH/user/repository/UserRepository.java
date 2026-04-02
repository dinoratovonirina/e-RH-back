package com.example.e_RH.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.e_RH.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String userEmail);
    Optional<User> findByEmailAndIsActiveTrue(String userEmail);
}
