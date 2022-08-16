package com.casestudy4.controller;

import com.casestudy4.dto.request.ForgotPasswordForm;
import com.casestudy4.dto.request.SignInForm;
import com.casestudy4.dto.request.SignUpForm;
import com.casestudy4.dto.response.JWTResponse;
import com.casestudy4.dto.response.ResponseMessage;
import com.casestudy4.model.Role;
import com.casestudy4.model.RoleName;
import com.casestudy4.model.User;
import com.casestudy4.security.jwt.JWTProvider;
import com.casestudy4.security.userprinciple.UserPrinciple;
import com.casestudy4.service.IRoleService;
import com.casestudy4.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTProvider jwtProvider;

    @GetMapping("/hello")
    public ResponseEntity<?> hello(){
        return new ResponseEntity<>("hello",HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpForm signUpForm){
        if(userService.existsByUsername(signUpForm.getUsername())){
            return new ResponseEntity<>(new ResponseMessage("Username Existed! Please try again!"), HttpStatus.OK);
        }
        if(userService.existsByEmail(signUpForm.getEmail())){
            return new ResponseEntity<>(new ResponseMessage("Email Existed! Please try again!"), HttpStatus.OK);
        }
        if(signUpForm.getPassword().length() < 6){
            return new ResponseEntity<>(new ResponseMessage("Password must be more than 6 characters"), HttpStatus.OK);
        }
        if(!signUpForm.getPassword().equals(signUpForm.getRe_enterPassword())){
            return new ResponseEntity<>(new ResponseMessage("Re-enter incorrect password!"), HttpStatus.OK);
        }
        User users = new User(signUpForm.getName(), signUpForm.getUsername(), passwordEncoder.encode(signUpForm.getPassword()), signUpForm.getEmail());
        Set<String> strRoles = signUpForm.getRoles();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role ->{
            switch (role){
                case "ADMIN":
                    Role adminRole = roleService.findByName(RoleName.ADMIN).orElseThrow( ()-> new RuntimeException("Role not found"));
                    roles.add(adminRole);
                    break;
                default:
                    Role userRole = roleService.findByName(RoleName.USER).orElseThrow( ()-> new RuntimeException("Role not found"));
                    roles.add(userRole);
            }
        });
        users.setRoles(roles);
        userService.save(users);
        return new ResponseEntity<>(new ResponseMessage("Created User Successfully!"), HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@Valid @RequestBody SignInForm signInForm){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getUsername(), signInForm.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return ResponseEntity.ok(new JWTResponse(userPrinciple.getId(),token, userPrinciple.getName(),userPrinciple.getAuthorities()));
    }

    @PostMapping("/forgotPassword")
    public ResponseEntity<?> forgotPassword(@RequestBody ForgotPasswordForm forgotPasswordForm){
        Boolean haveUser= userService.existsByUsername(forgotPasswordForm.getUsername());
        if(!haveUser){
            return new ResponseEntity<>(new ResponseMessage("Can not find this user"),HttpStatus.OK);
        }else{
            if (forgotPasswordForm.getPassword().length() < 6){
                return new ResponseEntity<>(new ResponseMessage("Password must be more than 6 characters"), HttpStatus.OK);
            }
            if (!forgotPasswordForm.getPassword().equals(forgotPasswordForm.getRe_enterPassword())){
                return new ResponseEntity<>(new ResponseMessage("Re-enter incorrect password!"), HttpStatus.OK);
            }
            Optional<User> user= userService.findUser(forgotPasswordForm.getUsername());
            user.get().setPassword(passwordEncoder.encode(forgotPasswordForm.getPassword()));
            userService.save(user.get());
        }
        return new ResponseEntity<>(new ResponseMessage("Your password have been changed!"),HttpStatus.OK);
    }

}
