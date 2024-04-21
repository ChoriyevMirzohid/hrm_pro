package com.hrm.hrm_pro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserRegDto {
    private Integer id;
    private String firstname;
    private String lastname;
    private String patronymic;
    private String email;
    private String login;
    private String password;
    private Integer role_code;
    private String condition;
    private String create_date;
    private String delete_date;

    public UserRegDto(Integer id, String firstname, String lastname, String patronymic, String email, String login, String password, Integer role_code, String condition, Timestamp create_date, Timestamp delete_date) {
        this.id = id;
        this.firstname = firstname;
        this.lastname=lastname;
        this.patronymic=patronymic;
        this.email = email;
        this.login = login;
        this.password = password;
        this.role_code=role_code;
        this.condition = condition;
        this.create_date = new SimpleDateFormat("dd.MM.yyyy HH:mm").format(create_date);
        this.delete_date = delete_date != null ? (new SimpleDateFormat("dd.MM.yyyy HH:mm").format(delete_date)) : "";
    }
}
