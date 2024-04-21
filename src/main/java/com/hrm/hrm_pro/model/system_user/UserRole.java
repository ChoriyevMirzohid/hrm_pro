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
@Entity(name = "UserRole")
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer user_id;

    private Integer role_code;

    @Column(nullable = false, length = 3)
    private String condition;

    @CreationTimestamp
    private Timestamp create_date;

    private Timestamp delete_date;
}
