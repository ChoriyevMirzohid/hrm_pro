package com.hrm.hrm_pro.model.system_emp;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "EmpCondition")
@Table(name = "emp_condition")
public class EmpCondition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 3, nullable = false, unique = true)
    private String code;

    @Column(nullable = false, length = 20)
    private String name;
}
