package com.videocall.videocallproject.user;

import java.util.List;
import java.util.stream.IntStream;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final List<User> USERS_LIST = new ArrayList<>();

    // Register User
    public void register(User user){
        user.setStatus("online");
        USERS_LIST.add(user);
    }

    // Login functionality
    public User login(User user) {
        var userIndex = IntStream.range(0, USERS_LIST.size())
                .filter(i -> USERS_LIST.get(i).getEmail().equals(user.getEmail()))
                .findAny()
                .orElseThrow(() -> new RuntimeException("User not found"));
        var cUser = USERS_LIST.get(userIndex);
        if (!cUser.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Password incorrect");
        }
        cUser.setStatus("online");
        return cUser;
    }
    

    // Logout functionality
    public void logout(String email){
        var userIndex = IntStream.range(0, USERS_LIST.size())
        .filter(i->USERS_LIST.get(i).getEmail().equals(email))
        .findAny()
        .orElseThrow(()->new RuntimeException("User not found"));
        USERS_LIST.get(userIndex).setStatus("offline");
        // System.out.println(USERS_LIST.get(userIndex).getStatus());
    }

    // Get all users
    public List<User> findAll(){
        return USERS_LIST;
    }
}
