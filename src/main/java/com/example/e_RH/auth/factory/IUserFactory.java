package com.example.e_RH.auth.factory;

import com.example.e_RH.auth.dto.RegisterRequest;
import com.example.e_RH.departement.entity.Departement;
import com.example.e_RH.role.entity.Role;
import com.example.e_RH.user.entity.User;

public interface IUserFactory {
    User create(RegisterRequest request, Role role, Departement departement);
}