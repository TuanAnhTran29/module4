package com.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private Integer id;

    @Column(nullable = false)
    @NotEmpty
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role(Integer id, String name, List<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public Role(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

    public Role() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
