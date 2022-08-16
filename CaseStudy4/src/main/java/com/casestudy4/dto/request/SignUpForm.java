package com.casestudy4.dto.request;

import java.util.Set;

public class SignUpForm {
    private String name;
    private String username;
    private String password;
    private String re_enterPassword;
    private String email;
    private Set<String> roles;

    public SignUpForm() {
    }

    public SignUpForm(String name, String username, String password, String re_enterPassword, String email, Set<String> roles) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.re_enterPassword = re_enterPassword;
        this.email = email;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public String getRe_enterPassword() {
        return re_enterPassword;
    }

    public void setRe_enterPassword(String re_enterPassword) {
        this.re_enterPassword = re_enterPassword;
    }
}
