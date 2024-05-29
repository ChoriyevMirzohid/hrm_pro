package com.hrm.hrm_pro.repository;

import com.hrm.hrm_pro.model.system_emp.BankEmp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BankEmpRepo extends JpaRepository<BankEmp, Integer> {
    @Query(value = "select new com.hrm.hrm_pro.model.system_emp.BankEmp(a.emp_id,\n" +
            "a.number,\n" +
            "COALESCE(a.code_unique, ''),\n" +
            "(select COALESCE('(' || t1.code || ') ' || t1.name_en, '') from BankBlock t1 where t1.code=a.bank_block), \n" +
            "(select COALESCE('(' || t1.code || ') ' || t1.name_en, '') from BankDirectorate t1 where t1.code=a.bank_direct), \n" +
            "(select COALESCE('(' || t1.code || ') ' || t1.name_en, '') from BankDepartment t1 where t1.code=a.bank_dep), \n" +
            "COALESCE(a.bank_dep_insade, ''),  \n" +
            "(select COALESCE('(' || t1.code || ') ' || t1.name_en, '') from EmpPosition t1 where t1.code=a.emp_position), \n" +
            "(select COALESCE('(' || t1.level_code || ') ' || t1.name_en, '') from EmpLevel t1 where t1.level_code=a.emp_level), \n" +
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
            "COALESCE(a.firstname, ''),\n" +
            "COALESCE(a.lastname, ''),\n" +
            "COALESCE(a.patronymic, ''),\n" +
            "COALESCE(a.creation_type, ''),\n" +
            "a.create_date,\n" +
            "COALESCE(a.condition, '')) from BankEmp a where \n" +
            "a.creation_type = 'create' and \n" +
            "CONCAT('F', a.emp_id, COALESCE(lower(a.firstname), '')) like %:filter% \n" +
        "UNION  ALL \n" +
            "select new com.hrm.hrm_pro.model.system_emp.BankEmp(a.emp_id,\n" +
            "a.number,\n" +
            "COALESCE(a.code_unique, ''),\n" +
            "COALESCE(a.bank_block, ''), \n" +
            "COALESCE(a.bank_direct, ''), \n" +
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
            "COALESCE(a.firstname, ''),\n" +
            "COALESCE(a.lastname, ''),\n" +
            "COALESCE(a.patronymic, ''),\n" +
            "COALESCE(a.creation_type, ''),\n" +
            "a.create_date,\n" +
            "COALESCE(a.condition, '')) from BankEmp a where \n" +
            "a.creation_type = 'import' and \n" +
            "a.firstname is not null and \n" +
            "CONCAT('F', a.emp_id, COALESCE(lower(a.firstname), '')) like %:filter% \n" +
            "ORDER BY a.emp_id DESC")
    Page<BankEmp> getAllBankEmpPaging(Pageable pageable, String filter);

    @Query(value = "select new com.hrm.hrm_pro.model.system_emp.BankEmp(a.emp_id,\n" +
            "a.number,\n" +
            "COALESCE(a.code_unique, ''),\n" +
            "(select COALESCE('(' || t1.code || ') ' || t1.name_en, '') from BankBlock t1 where t1.code=a.bank_block), \n" +
            "(select COALESCE('(' || t1.code || ') ' || t1.name_en, '') from BankDirectorate t1 where t1.code=a.bank_direct), \n" +
            "(select COALESCE('(' || t1.code || ') ' || t1.name_en, '') from BankDepartment t1 where t1.code=a.bank_dep), \n" +
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
            "COALESCE(a.firstname, ''),\n" +
            "COALESCE(a.lastname, ''),\n" +
            "COALESCE(a.patronymic, ''),\n" +
            "COALESCE(a.creation_type, ''),\n" +
            "a.create_date,\n" +
            "COALESCE(a.condition, '')) from BankEmp a where \n" +
            "a.creation_type = 'create' and \n" +
            "a.emp_id=:emp_id \n" +
            "UNION  ALL \n" +
            "select new com.hrm.hrm_pro.model.system_emp.BankEmp(a.emp_id,\n" +
            "a.number,\n" +
            "COALESCE(a.code_unique, ''),\n" +
            "COALESCE(a.bank_block, ''), \n" +
            "COALESCE(a.bank_direct, ''), \n" +
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
            "COALESCE(a.firstname, ''),\n" +
            "COALESCE(a.lastname, ''),\n" +
            "COALESCE(a.patronymic, ''),\n" +
            "COALESCE(a.creation_type, ''),\n" +
            "a.create_date,\n" +
            "COALESCE(a.condition, '')) from BankEmp a where \n" +
            "a.creation_type = 'import' and \n" +
            "a.firstname is not null and \n" +
            "a.emp_id=:emp_id")
    BankEmp getBankEmployeeById(Integer emp_id);

    @Query("select count(a) from BankEmp a where a.condition = '1'")
    int getEmpCount();
}
