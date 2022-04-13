package com.casestudy5.service;

import com.casestudy5.model.User;

import java.util.Optional;

public interface IUserService extends IGeneralService<User> {
    //user co ton tai trong DB khong
    Optional<User> findByUsername(String username);
    //username co trong DB chua
    Boolean existsByUsername(String username);
    //email co trong DB chua
    Boolean existsByEmail(String email);
    //phone co trong DB chua
    Boolean existsByPhone(String phone);

    Iterable<User> findAllRoleUser();

    Iterable<User> findAllUser();
}
