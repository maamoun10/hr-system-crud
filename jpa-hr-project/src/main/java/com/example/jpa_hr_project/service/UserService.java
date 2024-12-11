package com.example.jpa_hr_project.service;

import com.example.jpa_hr_project.entity.Employee;
import com.example.jpa_hr_project.entity.Role;
import com.example.jpa_hr_project.entity.User;
import com.example.jpa_hr_project.repository.RoleRepo;
import com.example.jpa_hr_project.repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleService roleService;

    public User findById(Long id){

        return userRepo.findById(id).orElseThrow();
    }

    public List<User> findAll(){

        return userRepo.findAll();
    }


    public User insert(User user)
    {
        return userRepo.save(user);
    }



    public User update(User user) {

        User found = userRepo.findById(user.getId()).get();
        found.setName(user.getName());
        found.setPassword(user.getPassword());
        found.setRoles(user.getRoles());

        return userRepo.save(found);

    }

    @Transactional
    public void addRoleForAllUser(String roleName){

        Role role =roleService.findByName(roleName);
        findAll().forEach(user ->{
                user.addRole(role);
        userRepo.save(user);
        });};


}


