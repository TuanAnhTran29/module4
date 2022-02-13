package com.service.role;

import com.model.entities.Role;
import com.repo.IRoleRepo;
import com.service.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepo roleRepo;
    @Override
    public Iterable<Role> findAll() {
        return roleRepo.findAll();
    }

    @Override
    public void save(Role role) {
        roleRepo.save(role);
    }

    @Override
    public Optional<Role> findById(Integer id) {
        return roleRepo.findById(id);
    }

    @Override
    public void remove(Integer id) {
        roleRepo.deleteById(id);
    }
}
