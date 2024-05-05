package com.hrm.hrm_pro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BankEmpDto {
    private Integer emp_id;
    private int number;
    private String code_unique;
    private String bank_block;
    private String bank_direct;
    private String bank_dep;
    private String bank_dep_insade;
    private String emp_position;
    private String emp_level;
    private String emp_manager;
    private String sub_employee;
    private String level_require;
    private String emp_skill;
    private String main_obligation;
    private String func_desc;
    private String responsibility;
    private String emp_law;
    private String conf_direct_man1;
    private String conf_direct_man2;
    private String conf_direct_man3;
    private String conf_direct_man4;

    private String firstname;
    private String lastname;
    private String patronymic;
    private String creation_type;

    private String create_date;
    private String condition;

    public BankEmpDto(Integer emp_id, int number, String code_unique, String bank_block, String bank_direct, String bank_dep, String bank_dep_insade, String emp_position, String emp_level, String emp_manager, String sub_employee, String level_require, String emp_skill, String main_obligation, String func_desc, String responsibility, String emp_law, String conf_direct_man1, String conf_direct_man2, String conf_direct_man3, String conf_direct_man4, String firstname, String lastname, String patronymic, String creation_type, Timestamp create_date, String condition) {
        this.emp_id = emp_id;
        this.number = number;
        this.code_unique = code_unique;
        this.bank_block = bank_block;
        this.bank_direct = bank_direct;
        this.bank_dep = bank_dep;
        this.bank_dep_insade = bank_dep_insade;
        this.emp_position = emp_position;
        this.emp_level = emp_level;
        this.emp_manager = emp_manager;
        this.sub_employee = sub_employee;
        this.level_require = level_require;
        this.emp_skill = emp_skill;
        this.main_obligation = main_obligation;
        this.func_desc = func_desc;
        this.responsibility = responsibility;
        this.emp_law = emp_law;
        this.conf_direct_man1 = conf_direct_man1;
        this.conf_direct_man2 = conf_direct_man2;
        this.conf_direct_man3 = conf_direct_man3;
        this.conf_direct_man4 = conf_direct_man4;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.creation_type = creation_type;
        this.create_date = new SimpleDateFormat("dd.MM.yyyy HH:mm").format(create_date);
        this.condition = condition;
    }
}
