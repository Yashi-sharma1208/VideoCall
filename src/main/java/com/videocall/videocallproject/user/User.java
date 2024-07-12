package com.videocall.videocallproject.user;
import lombok.Data;
import lombok.Builder;
@Data
@Builder
public class User {
    private String username;
    private String email;
    private String password;
    private String status;
}
