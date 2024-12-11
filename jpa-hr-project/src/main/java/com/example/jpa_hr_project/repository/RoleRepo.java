package com.example.jpa_hr_project.repository;

import com.example.jpa_hr_project.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {

     Role findByName(String name);

}
