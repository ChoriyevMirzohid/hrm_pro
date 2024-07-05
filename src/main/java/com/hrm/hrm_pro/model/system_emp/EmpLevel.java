package com.hrm.hrm_pro.model.system_emp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "EmpLevel")
@Table(name = "emp_level")
public class EmpLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String level_code;

    @Column(length = 100)
    private String name_uz;

    @Column(length = 100)
    private String name_ru;

    @Column(length = 100)
    private String name_en;

    @Column(columnDefinition = "varchar(3) default '1'")
    private String condition;

    @CreationTimestamp
    @Column(columnDefinition = "timestamp default current_timestamp")
    private Timestamp create_date;

    private Timestamp delete_date;
}
