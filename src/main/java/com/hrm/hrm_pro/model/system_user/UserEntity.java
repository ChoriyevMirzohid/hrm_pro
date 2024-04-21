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
@Entity(name = "UserEntity")
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 40, nullable = false)
    private String firstname;

    @Column(length = 40, nullable = false)
    private String lastname;

    @Column(length = 40, nullable = false)
    private String patronymic;

    @Column(length = 50, unique = true)
    private String login;

    @Column(length = 100)
    private String password;

    @Column(length = 50, unique = true)
    private String email;

    @Column(nullable = false, length = 3)
    private String condition;

    @CreationTimestamp
    private Timestamp create_date;

    private Timestamp delete_date;
}
