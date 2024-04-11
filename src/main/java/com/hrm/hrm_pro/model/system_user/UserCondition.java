package com.hrm.hrm_pro.model.system_user;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "UserContition")
@Table(name = "user_condition")
public class UserCondition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 3, nullable = false, unique = true)
    private String code;

    @Column(nullable = false, length = 20)
    private String name;
}
