package com.hrm.hrm_pro.model.system_emp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
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
    @Column(length = 2000)
    private String code_unique;
    @Column(length = 2000)
    private String bank_block;
    @Column(length = 2000)
    private String bank_direct;
    @Column(length = 2000)
    private String bank_dep;
    @Column(length = 2000)
    private String bank_dep_insade;
    @Column(length = 2000)
    private String emp_position;
    @Column(length = 2000)
    private String emp_level;
    @Column(length = 2000)
    private String emp_manager;
    @Column(length = 2000)
    private String sub_employee;
    @Column(length = 2000)
    private String level_require;
    @Column(length = 2000)
    private String emp_skill;
    @Column(length = 2000)
    private String main_obligation;
    @Column(length = 2000)
    private String func_desc;
    @Column(length = 2000)
    private String responsibility;
    @Column(length = 2000)
    private String emp_law;
    @Column(length = 2000)
    private String conf_direct_man1;
    @Column(length = 2000)
    private String conf_direct_man2;
    @Column(length = 2000)
    private String conf_direct_man3;
    @Column(length = 2000)
    private String conf_direct_man4;

    @Column(length = 40)
    private String firstname;

    @Column(length = 40)
    private String lastname;

    @Column(length = 40)
    private String patronymic;

    @Column(length = 20)
    private String creation_type;

    @CreationTimestamp
    private Timestamp create_date;
    @Column(length = 3, nullable = false)
    private String condition;
}
