package com.casestudy4.service;

import com.casestudy4.model.Role;
import com.casestudy4.model.RoleName;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface IRoleService extends IGeneralService<Role> {
    Optional<Role> findByName(RoleName roleName);
}
