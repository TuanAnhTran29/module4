package com.model;

import com.model.entities.Role;
import com.model.entities.User;

import javax.persistence.*;

@Entity
@Table
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "USER_ID",nullable = false)
    @ManyToOne
    private User user;

    @JoinColumn(name = "ROLE_ID",nullable = false)
    @ManyToOne
    private Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
