package com.service;

import com.model.UserRole;
import com.model.entities.User;
import com.repo.IUserRepo;
import com.repo.IUserRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserDetailService implements UserDetailsService {
    @Autowired
    private IUserRepo userRepo;

    @Autowired
    private IUserRoleRepo userRoleRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userRepo.findByEmail(username);

        if (user == null){
            System.out.println("User not found! " + username);
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        System.out.println("Found user: " + username);

        List<UserRole> userRoles= userRoleRepo.findByUser(user);

        List<GrantedAuthority> authorities= new ArrayList<GrantedAuthority>();
        if (userRoles != null){
            for (UserRole userRole: userRoles){
                GrantedAuthority authority= new SimpleGrantedAuthority(userRole.getRole().getName());
                authorities.add(authority);
            }
        }

        UserDetails userDetails= new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
        return userDetails;
    }


}
