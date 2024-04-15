package com.hrm.hrm_pro.repository;

import com.hrm.hrm_pro.model.system_emp.EmpCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpConditionRepo extends JpaRepository<EmpCondition, Integer> {

}
