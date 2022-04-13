package com.casestudy5.service.impl;

import com.casestudy5.model.Role;
import com.casestudy5.model.RoleName;
import com.casestudy5.repo.IRoleRepo;
import com.casestudy5.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepo roleRepo;
    @Override
    public Optional<Role> findByName(RoleName roleName) {
        return roleRepo.findByName(roleName);
    }

    @Override
    public List<Role> findAll() {
        return roleRepo.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepo.findById(id);
    }

    @Override
    public Role save(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void remove(Long id) {
        roleRepo.deleteById(id);
    }
}
