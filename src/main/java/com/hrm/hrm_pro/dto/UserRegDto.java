package com.hrm.hrm_pro.dto;

import com.hrm.hrm_pro.service.UserConditionS;
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
    private String fullname;
    private String email;
    private String login;
    private String password;
    private String condition;
    private String create_date;
    private String delete_date;

    public UserRegDto(Integer id, String fullname, String email, String login, String password, String condition, Timestamp create_date, Timestamp delete_date) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.login = login;
        this.password = password;
        this.condition = condition;
        this.create_date = new SimpleDateFormat("dd.MM.yyyy HH:mm").format(create_date);
        this.delete_date = delete_date != null ? (new SimpleDateFormat("dd.MM.yyyy HH:mm").format(delete_date)) : "";
    }
}
