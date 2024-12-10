package com.example.jpa_hr_project.service;

import com.example.jpa_hr_project.entity.Employee;
import com.example.jpa_hr_project.entity.Role;
import com.example.jpa_hr_project.entity.User;
import com.example.jpa_hr_project.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
@Autowired
RoleRepo roleRepo;
    public Role findById(Long id){
        return roleRepo.findById(id).orElseThrow();
    }


    public Role insert(Role role)
    {
        return roleRepo.save(role);
    }


    public Role update(Role role) {

        Role found = roleRepo.findById(role.getId()).get();
        found.setName(role.getName());

        return roleRepo.save(found);


    }

}
