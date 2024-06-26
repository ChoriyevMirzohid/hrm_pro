package com.hrm.hrm_pro.model.system_emp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "BankEmp")
@Table(name = "bank_emp")
public class BankEmp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer emp_id;

    private int number;
    @Column(length = 200)
    private String code_unique;
    @Column(length = 200)
    private String bank_block;
    @Column(length = 200)
    private String bank_direct;
    @Column(length = 200)
    private String bank_dep;
    @Column(length = 200)
    private String bank_dep_insade;
    @Column(length = 200)
    private String emp_position;
    @Column(length = 200)
    private String emp_level;
    @Column(length = 200)
    private String emp_manager;
    @Column(length = 5000)
    private String sub_employee;
    @Column(length = 5000)
    private String level_require;
    @Column(length = 5000)
    private String emp_skill;
    @Column(length = 5000)
    private String main_obligation;
    @Column(length = 5000)
    private String func_desc;
    @Column(length = 5000)
    private String responsibility;
    @Column(length = 5000)
    private String emp_law;
    @Column(length = 200)
    private String conf_direct_man1;

    @Column(length = 200)
    private String conf_direct_level1;

    @Column(length = 200)
    private String conf_direct_man2;
    @Column(length = 200)
    private String conf_direct_man3;

    @Column(length = 200)
    private String conf_direct_level2;
    @Column(length = 200)
    private String conf_direct_man4;

    @Column(length = 200)
    private String firstname;

    @Column(length = 200)
    private String lastname;

    @Column(length = 200)
    private String patronymic;

    @Column(length = 20)
    private String creation_type;

    private Date employment_date;

    @CreationTimestamp
    private Timestamp create_date;
    @Column(length = 3, nullable = false)
    private String condition;

    private int block_id;
    private int direct_id;
    private int depart_id;
    private int position_id;
    private int level_id;
}
