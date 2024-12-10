package com.example.jpa_hr_project.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sec_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id ;


    private String name;

    private String password;
    @OneToOne(mappedBy = "user")
    private Employee employee;

    @ManyToMany
    @JoinTable(name = "sec_user_roles",
     joinColumns =@JoinColumn(name="user_id"),
     inverseJoinColumns = @JoinColumn(name="rol_id"))
    private Set<Role> roles=new HashSet<>();

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public User() {
    }

    public User(String password, String name, long id) {
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
