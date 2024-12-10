package com.example.jpa_hr_project.controller;

import com.example.jpa_hr_project.entity.Employee;
import com.example.jpa_hr_project.service.ServiceEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    ServiceEmployee serviceEmployee;


    @GetMapping("/{id}")
    public Employee findBYId(@PathVariable Long id){
        return serviceEmployee.findById(id);
    };

    @PostMapping("/post")
    public Long insert(@RequestBody Employee employee){
        Employee emp =serviceEmployee.insert(employee);
        return emp.getId();
    };

    @PutMapping("/put")
    public Employee update(@RequestBody Employee employee){
        return serviceEmployee.update(employee);
    };

    @GetMapping("/emmp/{id}")
    public List<Employee> findByDepartmentId(@PathVariable Long id){
        return serviceEmployee.findByDepartmentId(id);
    };
    @GetMapping("/emmpQu/{id}")
    public List<Employee> findByDepartment(@PathVariable Long id){
        return serviceEmployee.findByDepartmentId(id);
    };
    @GetMapping("/empdept")
   public List<Employee> findByNameContainingAndDepartmentNameContaining(@RequestParam String ename, @RequestParam String depname){

       return serviceEmployee.findByNameContainingDepartmentNameContaining(ename,depname);
    };

    @GetMapping("/empdeldept")
    public ResponseEntity<Long> deleteByNameContainingAndDepartmentNameContaining(@RequestParam String ename, @RequestParam String depname){

        return ResponseEntity.ok(serviceEmployee.deleteByNameContainingAndDepartmentNameContaining(ename,depname));
    };

    @GetMapping("/countempdept")
    public ResponseEntity<Long> countByNameContainingAndDepartmentNameContaining(@RequestParam String ename, @RequestParam String depname){

        return ResponseEntity.ok(serviceEmployee.countByNameContainingAndDepartmentNameContaining(ename,depname));
    };



}
