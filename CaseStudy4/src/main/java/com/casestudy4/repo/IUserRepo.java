package com.casestudy4.repo;

import com.casestudy4.model.Song;
import com.casestudy4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query(value = "select * from users inner join user_role ur on users.id = ur.user_id where ur.role_id= 2",nativeQuery = true)
    Iterable<User> findAllRoleUser();

    @Query(value = "select * from users inner join user_role ur on users.id = ur.user_id where users.username= ?1 and ur.role_id= 2", nativeQuery = true)
    Optional<User> findUserByUsername(String username);

    @Query(value = "select * from users where users.username= ?1", nativeQuery = true)
    Optional<User> findUser(String username);
}
