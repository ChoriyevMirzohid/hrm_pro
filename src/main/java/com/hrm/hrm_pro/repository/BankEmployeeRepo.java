package com.hrm.hrm_pro.repository;

import com.hrm.hrm_pro.dto.BankEmployeeDto;
import com.hrm.hrm_pro.model.system_emp.BankEmployee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BankEmployeeRepo extends JpaRepository<BankEmployee, Integer> {
    @Query("select\n" +
            "    new com.hrm.hrm_pro.dto.BankEmployeeDto(a.emp_id,\n" +
            "    a.emp_depart_code,\n" +
            "    ( select bl.code || '-' || bl.name_en from BankBlock bl where bl.id = a.block_id ),\n" +
            "    ( select bd.code || '-' || bd.name_en from BankDirectorate bd where bd.id = a.directorate_id ),\n" +
            "    ( select bc.code || '-' || bc.name_en from BankDepartment bc where bc.id = a.department_id ),\n" +
            "    a.firstname,\n" +
            "    a.lastname,\n" +
            "    a.patronymic,\n" +
            "    a.short_name,\n" +
            "    ( select e.level_code || '-' || e.name_en from EmpLevel e where e.id = a.level_id ),\n" +
            "    ( select p.name_en from EmpPosition p where p.id = a.position_id ),\n" +
            "    a.employment_date,\n" +
            "    a.condition,\n" +
            "    a.create_date,\n" +
            "    a.delete_date)\n" +
            "from Employee a")
    Page<BankEmployeeDto> getAllBankEmployeePaging(Pageable pageable);
}
