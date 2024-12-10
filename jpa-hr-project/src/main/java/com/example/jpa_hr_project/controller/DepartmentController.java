package com.example.jpa_hr_project.controller;


import com.example.jpa_hr_project.entity.Department;
import com.example.jpa_hr_project.entity.Employee;
import com.example.jpa_hr_project.service.ServiceDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    ServiceDepartment serviceDepartment;


    @PostMapping("/post")
    public Department insertCon(@RequestBody Department department){
        return serviceDepartment.insert(department);
    };

    @PutMapping("/put")
    public Department updateCon( @RequestBody Department department){
        return serviceDepartment.update(department);
    };

}
