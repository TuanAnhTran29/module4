package com.casestudy5.service;

import com.casestudy5.model.Role;
import com.casestudy5.model.RoleName;

import java.util.Optional;


public interface IRoleService extends IGeneralService<Role> {
    Optional<Role> findByName(RoleName roleName);
}
