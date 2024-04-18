package com.hrm.hrm_pro.dto;

import lombok.Data;

@Data
public class LoginDto {
    private String login;
    private String password;

    public LoginDto(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
