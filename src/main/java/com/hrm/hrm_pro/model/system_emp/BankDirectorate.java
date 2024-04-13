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
@Entity(name = "BankDirectorate")
@Table(name = "bank_directorate")
public class BankDirectorate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10)
    private String code;

    private Integer block_id;

    @Column(length = 100)
    private String name_uz;

    @Column(length = 100)
    private String name_ru;

    @Column(length = 100)
    private String name_en;

    private Integer deputy_id;

    @Column(length = 3)
    private String condition;

    @CreationTimestamp
    private Timestamp create_date;

    private Timestamp delete_date;
}
