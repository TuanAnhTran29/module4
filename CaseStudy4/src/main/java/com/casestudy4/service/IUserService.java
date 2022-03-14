package com.casestudy4.service;

import com.casestudy4.model.Song;
import com.casestudy4.model.User;

import java.util.Optional;

public interface IUserService extends IGeneralService<User> {
    //user co ton tai trong DB khong
    Optional<User> findByUsername(String username);
    //username co trong DB chua
    Boolean existsByUsername(String username);
    //email co trong DB chua
    Boolean existsByEmail(String email);

    Iterable<User> findAllRoleUser();
}
