package com.casestudy5.service.impl;

import com.casestudy5.model.User;
import com.casestudy5.repo.IUserRepo;
import com.casestudy5.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepo userRepo;
    @Override
    public Optional<User> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepo.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepo.existsByEmail(email);
    }

    @Override
    public Boolean existsByPhone(String phone) {
        return userRepo.existsByPhone(phone);
    }

    @Override
    public Iterable<User> findAllRoleUser() {
        return userRepo.findAllRoleUser();
    }

    @Override
    public Iterable<User> findAllUser() {
        return userRepo.findAllUser();
    }

    @Override
    public Iterable<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public void remove(Long id) {
        userRepo.deleteById(id);
    }
}
