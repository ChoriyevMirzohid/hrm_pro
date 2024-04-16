package com.hrm.hrm_pro.model.system_emp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "EmpPosition")
@Table(name = "emp_position")
public class EmpPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10)
    private String code;

    @Column(length = 100)
    private String name_uz;

    @Column(length = 100)
    private String name_ru;

    @Column(length = 100)
    private String name_en;

    @Column(length = 3)
    private String condition;

    @CreationTimestamp
    private Timestamp create_date;

    private Timestamp delete_date;
}
