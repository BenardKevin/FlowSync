package com.ib.flowsync.dto;

import lombok.Data;

@Data
public class RegisterDto {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
