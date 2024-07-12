package com.videocall.videocallproject.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
public class UserController {
    private final UserService service;

    // Register User
    @PostMapping
    public void register(@RequestBody User user){
        System.out.println("values = "+user);
        service.register(user);
    }

    // Login
    @PostMapping("/login")
    public User login(@RequestBody User user){
        return service.login(user);
    } 

    // Logout 
    @PostMapping("/logout")
    public void logout(@RequestBody User user){
       service.logout(user.getEmail());
    }

    // Get all users
    @GetMapping
    public List<User> findAll(){
       return service.findAll();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Exception e){
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(e.getMessage());
    }
}
