package com.example.e_RH.auth.service;

import org.springframework.stereotype.Service;

import com.example.e_RH.auth.dto.RegisterRequest;
import com.example.e_RH.departement.entity.Departement;
import com.example.e_RH.departement.service.DepartementService;
import com.example.e_RH.role.entity.Role;
import com.example.e_RH.role.enums.RoleTypeEnum;
import com.example.e_RH.role.service.RoleService;
import com.example.e_RH.user.entity.User;
import com.example.e_RH.user.factory.IUserFactory;
import com.example.e_RH.user.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final IUserFactory userFactory;
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final DepartementService departementService;

    public User register(RegisterRequest request) {
        Role role;
        if (request.roleId() == null) {
            role = roleService.getRoleByName(RoleTypeEnum.EMPLOYEE)
                    .orElseThrow(() -> new EntityNotFoundException("Role not found"));
        } else {
            role = roleService.getRoleById(request.roleId())
                    .orElseThrow(() -> new EntityNotFoundException("Role not found"));
        }

        Departement departement = null;
        if (request.departementId() != null) {
            departement = departementService.getDepartementById(request.departementId())
                    .orElseThrow(() -> new EntityNotFoundException("Department not found"));
        }
        return userRepository.save(this.userFactory.create(request, role, departement));
    }
}
