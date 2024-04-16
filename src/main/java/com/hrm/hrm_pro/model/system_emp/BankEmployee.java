package com.hrm.hrm_pro.model.system_emp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "BankEmployee")
@Table(name = "bank_employee")
public class BankEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer emp_id;

    @Column(nullable = false, length = 40)
    private String emp_depart_code;
    private Integer block_id;
    private Integer directorate_id;
    private Integer department_id;
    private Integer level_id;
    private Integer position_id;

    @Column(nullable = false, length = 40)
    private String firstname;

    @Column(nullable = false, length = 40)
    private String lastname;

    @Column(nullable = false, length = 40)
    private String patronymic;

    @Column(nullable = false, length = 40)
    private String short_name;

    private Date employment_date;

    @Column(length = 3)
    private String condition;

    @CreationTimestamp
    private Timestamp create_date;

    private Timestamp delete_date;
}
