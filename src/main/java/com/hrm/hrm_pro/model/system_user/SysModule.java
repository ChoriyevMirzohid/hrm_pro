package com.hrm.hrm_pro.model.system_user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "SysModule")
@Table(name = "sys_module")
public class SysModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 2, nullable = false)
    private Integer code;

    @Column(length = 100, nullable = false)
    private String name_uz;

    @Column(length = 100, nullable = false)
    private String name_ru;

    @Column(length = 100, nullable = false)
    private String name_en;

    @Column(length = 100, nullable = false)
    private String page_url;

    @Column(length = 100, nullable = false)
    private String page_icon;

    @Column(nullable = false)
    private String page_type;

    @Column(nullable = false, length = 3)
    private String condition;

    @CreationTimestamp
    private Timestamp create_date;
}
