package com.hrm.hrm_pro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankEmployeeDto {
    private Integer emp_id;
    private String emp_depart_code;
    private Integer block_id;
    private Integer directorate_id;
    private Integer department_id;
    private Integer level_id;
    private Integer position_id;
    private String firstname;
    private String lastname;
    private String patronymic;
    private String short_name;
    private Date employment_date;
    private String condition;
    private String create_date;
    private String delete_date;
}
