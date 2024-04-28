package com.hrm.hrm_pro.repository;

import com.hrm.hrm_pro.model.system_emp.BankEmployeeOld;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BankEmployeeOldRepo extends JpaRepository<BankEmployeeOld, Integer> {
    @Query(value = "select new com.hrm.hrm_pro.model.system_emp.BankEmployeeOld(a.emp_id,\n" +
            "a.number,\n" +
            "COALESCE(a.code_unique, ''),\n" +
            "COALESCE(a.bank_block, ''), \n" +
            "COALESCE(a.bank_direct, ''),  \n" +
            "COALESCE(a.bank_dep, ''), \n" +
            "COALESCE(a.bank_dep_insade, ''),  \n" +
            "COALESCE(a.emp_position, ''), \n" +
            "COALESCE(a.emp_level, ''),  \n" +
            "COALESCE(a.emp_manager, ''),  \n" +
            "COALESCE(a.sub_employee, ''), \n" +
            "COALESCE(a.level_require, ''),  \n" +
            "COALESCE(a.emp_skill, ''),  \n" +
            "COALESCE(a.main_obligation, ''),  \n" +
            "COALESCE(a.func_desc, ''),  \n" +
            "COALESCE(a.responsibility, ''), \n" +
            "COALESCE(a.emp_law, ''),  \n" +
            "COALESCE(a.conf_direct_man1, ''), \n" +
            "COALESCE(a.conf_direct_man2, ''), \n" +
            "COALESCE(a.conf_direct_man3, ''), \n" +
            "COALESCE(a.conf_direct_man4, ''),\n" +
            "COALESCE(a.fullname, ''),\n" +
            "a.create_date,\n" +
            "COALESCE(a.condition, '')) from BankEmployeeOld a where \n" +
            "CONCAT('F', a.emp_id, COALESCE(lower(a.fullname), '')) like %:filter% \n" +
            "ORDER BY a.emp_id DESC")
    Page<BankEmployeeOld> getAllBankEmpOldPaging(Pageable pageable, String filter);
}
