package com.service.user;

import com.model.entities.User;
import com.repo.IUserRepo;
import com.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepo userRepo;
    @Override
    public Iterable<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepo.findById(id);
    }

    @Override
    public void remove(Integer id) {
        userRepo.deleteById(id);
    }
}
