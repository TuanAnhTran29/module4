package com.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class User implements Validator {
    @NotEmpty
    @Size(min = 5, max = 45)
    private String firstName;

    @NotEmpty
    @Size(min = 5, max = 45)
    private String lastName;

    @Min(18)
    private int age;

    @Email
    private String email;

    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(@NotEmpty @Size(min = 5, max = 45) String firstName, @NotEmpty @Size(min = 5, max = 45) String lastName, @Min(18) int age, @Email String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User() {
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user= (User) target;
        String phoneNumber= user.getPhoneNumber();
        ValidationUtils.rejectIfEmpty(errors,"phoneNumber","number.empty");
        if (phoneNumber.length() > 11 || phoneNumber.length() < 10){
            errors.rejectValue("phoneNumber","number.length");
        }
        if (!phoneNumber.matches("(84|0[3|5|7|8|9])+([0-9]{8})\\b")){
            errors.rejectValue("phoneNumber","number.matches");
        }
    }
}
