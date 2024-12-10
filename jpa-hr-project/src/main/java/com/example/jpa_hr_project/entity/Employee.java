package com.example.jpa_hr_project.entity;

import jakarta.persistence.*;
@Table(name = "hr_employee")
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long id;
    @Column(name = "emp_name")
    private String name;
    @Column(name = "emp_salary")
    private int salary;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @OneToOne()
    @JoinColumn(name = "user_id")
    private User user;

    public Department getDepartment() {
        return department;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Employee() {
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee(int salary, String name, long id,Department department) {
        this.salary = salary;
        this.name = name;
        this.id = id;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
