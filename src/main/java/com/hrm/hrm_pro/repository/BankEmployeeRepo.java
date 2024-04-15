package com.hrm.hrm_pro.repository;

import com.hrm.hrm_pro.model.system_emp.BankEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankEmployeeRepo extends JpaRepository<BankEmployee, Integer> {

}
