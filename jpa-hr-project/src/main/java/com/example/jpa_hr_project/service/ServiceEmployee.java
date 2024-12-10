package com.example.jpa_hr_project.service;

import com.example.jpa_hr_project.entity.Employee;
import com.example.jpa_hr_project.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEmployee {
 @Autowired
 EmployeeRepo employeeRepo;

 public Employee findById(Long id){
     return employeeRepo.findById(id).orElseThrow();
 }

 public Employee insert(Employee emp)
 {
     return employeeRepo.save(emp);
 }

 public Employee update(Employee emp){
    Employee found = employeeRepo.findById(emp.getId()).get();
     found.setName(emp.getName());
     found.setSalary(emp.getSalary());
     found.setDepartment(emp.getDepartment());
     found.setUser(emp.getUser());
     return employeeRepo.save(found);
 }
 public List<Employee> findByDepartmentId(Long id){
  return employeeRepo.findByDepartmentId(id);
 };
 public List<Employee> findByDepartment(Long id){
  return employeeRepo.findByDepartment(id);
 };
public List<Employee> findByNameContainingDepartmentNameContaining(String ename,String depname){
 return employeeRepo.findByNameContainingAndDepartmentNameContaining(ename,depname);

}

 public Long countByNameContainingAndDepartmentNameContaining(String ename,String depname){

 return employeeRepo.countByNameContainingAndDepartmentNameContaining(ename,depname);

 };
 public Long deleteByNameContainingAndDepartmentNameContaining(String ename,String depname){

  return employeeRepo.deleteByNameContainingAndDepartmentNameContaining(ename,depname);
 };



};