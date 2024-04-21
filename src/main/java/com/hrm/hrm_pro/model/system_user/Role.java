package com.hrm.hrm_pro.model.system_user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Role")
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 2, unique = true, nullable = false)
    private Integer code;

    @Column(length = 20, unique = true, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String title;
}
