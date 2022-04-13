package com.casestudy5.repo;

import com.casestudy5.model.Role;
import com.casestudy5.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepo extends JpaRepository<Role,Long> {
    Optional<Role> findByName(RoleName roleName);
}
