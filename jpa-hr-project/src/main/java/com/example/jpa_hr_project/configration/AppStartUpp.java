package com.example.jpa_hr_project.configration;

import com.example.jpa_hr_project.entity.Role;
import com.example.jpa_hr_project.entity.User;
import com.example.jpa_hr_project.service.RoleService;
import com.example.jpa_hr_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
@Component
public class AppStartUpp implements CommandLineRunner {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
while (userService.findAll().isEmpty()) {
    Role role1 = new Role();
    role1.setName("Admin");

    Role role2 = new Role();
    role2.setName("moderator");
    Set<Role> roleSet1 = new HashSet<>();
    roleSet1.add(role1);

    Set<Role> roleSet2 = new HashSet<>();
    roleSet1.add(role2);


    roleService.insert(role1);
    roleService.insert(role2);


    User user1 = new User();
    user1.setName("Admin");
    user1.setPassword("123");
    user1.setRoles(roleSet1);
    userService.insert(user1);
    User user2 = new User();
    user2.setName("moderator");
    user2.setPassword("456");
    user2.setRoles(roleSet2);
    userService.insert(user2);


}
    }
}
