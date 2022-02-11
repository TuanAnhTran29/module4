package com.service;

import com.model.Role;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}
