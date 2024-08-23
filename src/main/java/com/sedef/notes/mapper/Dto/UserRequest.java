package com.sedef.notes.mapper.Dto;

import lombok.Data;

@Data
public class UserRequest {
    private String firstName;
    private String surname;
    private String email;
    private String password;
}
