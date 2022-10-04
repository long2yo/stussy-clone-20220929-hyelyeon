package com.stussy.stussyclone20220929hyelyeon.dto.account;

import lombok.Data;

@Data
public class RegisterReqDto {
    private String lastName;
    private String firstName;
    private String email;
    private String password;
}
