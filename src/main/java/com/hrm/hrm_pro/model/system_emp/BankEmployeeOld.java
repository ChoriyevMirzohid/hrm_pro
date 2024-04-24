package com.hrm.hrm_pro.model.system_emp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "BankEmployeeOld")
@Table(name = "bank_employee_old")
public class BankEmployeeOld {
    @Id
    private Integer customerId;
    private String firstName;
    private String lastName;
    private String country;
    private String telephone;
}
