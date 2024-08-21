package com.sedef.notes.Dto;

import lombok.Data;

@Data
public class UserRequest {
    private String firstName;
    private String Surname;
    private String email;
    private String password;
}
