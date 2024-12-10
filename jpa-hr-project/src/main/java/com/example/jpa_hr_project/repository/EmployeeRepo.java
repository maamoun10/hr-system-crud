package com.example.jpa_hr_project.repository;

import com.example.jpa_hr_project.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

List<Employee>findByDepartmentId(Long id);

@Query("select emp from Employee emp join emp.department dept where dept.id=:id ")
List<Employee>findByDepartment(Long id);

List<Employee> findByNameContainingAndDepartmentNameContaining(String ename,String depname);

Long countByNameContainingAndDepartmentNameContaining(String ename,String depname);

@Transactional
 Long deleteByNameContainingAndDepartmentNameContaining(String ename,String depname);

}
