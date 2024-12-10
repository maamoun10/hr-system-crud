package com.example.jpa_hr_project.service;

import com.example.jpa_hr_project.entity.Department;
import com.example.jpa_hr_project.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDepartment {

    @Autowired
    DepartmentRepo departmentRepo;

    public Department findById(Long id){
        return departmentRepo.findById(id).orElseThrow();
    }

    public Department insert(Department department)
    {
        return departmentRepo.save(department);
    }


    public Department update(Department department){

        Department foundDept = departmentRepo.findById(department.getId()).get();
        foundDept.setName(department.getName());
        return departmentRepo.save(foundDept);

    }


}
