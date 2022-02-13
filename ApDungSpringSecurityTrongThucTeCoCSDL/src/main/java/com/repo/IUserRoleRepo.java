package com.repo;

import com.model.UserRole;
import com.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepo extends JpaRepository<UserRole,Integer> {
    List<UserRole> findByUser(User user);
}
