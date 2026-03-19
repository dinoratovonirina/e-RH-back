package com.example.e_RH.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.e_RH.users.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
