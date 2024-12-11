package com.example.jpa_hr_project.controller;

import com.example.jpa_hr_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
@PutMapping("/role/{roleName}")
public ResponseEntity<?> addRoleForAllUser(@PathVariable String roleName){

    userService.addRoleForAllUser(roleName);
    return ResponseEntity.ok(null);
}

}
