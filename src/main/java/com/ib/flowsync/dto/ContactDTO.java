package com.ib.flowsync.dto;

import lombok.Data;

@Data
public class ContactDTO {
    private String firstname;
    private String lastname;
    private String email;
    private String  phoneNumber;
    private Integer addressId;
}
