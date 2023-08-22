package com.backend.dtos;

import java.util.List;

import com.backend.pojos.enums.UserRole;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
    // private Long userId;
    private String firstName;
    private String lastName;
    private UserRole role = UserRole.CUSTOMER;
    private String userEmail;
    private String mobileNumber;
    private String password;
    // private byte[] userImage;
}
