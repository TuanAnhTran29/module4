package com.casestudy5.repo;


import com.casestudy5.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepo extends JpaRepository<User,Long> {
    //user co ton tai trong DB khong
    Optional<User> findByUsername(String username);
    //username co trong DB chua
    Boolean existsByUsername(String username);
    //email co trong DB chua
    Boolean existsByEmail(String email);
    //phone co trong DB chua
    Boolean existsByPhone(String phone);

    @Query(value = "select * from users inner join user_role ur on users.id = ur.user_id where ur.role_id= 2",nativeQuery = true)
    Iterable<User> findAllRoleUser();

    @Query(value = "select * from users inner join user_role ur on users.id = ur.user_id where ur.role_id= 1", nativeQuery = true)
    Iterable<User> findAllUser();
}
