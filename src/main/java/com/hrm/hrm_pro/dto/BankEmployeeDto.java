package com.hrm.hrm_pro.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Data
@NoArgsConstructor
public class BankEmployeeDto {
    private Integer emp_id;
    private String emp_depart_code;
    private String block;
    private String directorate;
    private String department;
    private String firstname;
    private String lastname;
    private String patronymic;
    private String short_name;
    private String level;
    private String position;
    private String employment_date;
    private String condition;
    private String create_date;
    private String delete_date;

    private Integer block_id;
    private Integer directorate_id;
    private Integer department_id;
    private Integer level_id;
    private Integer position_id;

    public BankEmployeeDto(Integer emp_id, String emp_depart_code, String block, String directorate, String department, String firstname, String lastname, String patronymic, String short_name, String level, String position, Date employment_date, String condition, Timestamp create_date, Timestamp delete_date, Integer block_id, Integer directorate_id, Integer department_id, Integer level_id, Integer position_id) {
        this.emp_id = emp_id;
        this.emp_depart_code = emp_depart_code;
        this.block = block;
        this.directorate = directorate;
        this.department = department;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.short_name = short_name;
        this.level = level;
        this.position = position;
        this.employment_date = new SimpleDateFormat("yyyy-MM-dd").format(employment_date);
        this.condition = condition;
        this.create_date = new SimpleDateFormat("dd.MM.yyyy HH:mm").format(create_date);
        this.delete_date = delete_date != null ? (new SimpleDateFormat("dd.MM.yyyy HH:mm").format(delete_date)) : "";
        this.block_id=block_id;
        this.directorate_id=directorate_id;
        this.department_id=department_id;
        this.level_id=level_id;
        this.position_id=position_id;
    }

    public BankEmployeeDto(Integer emp_id, String firstname, String lastname, String patronymic) {
        this.emp_id = emp_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
    }
}
