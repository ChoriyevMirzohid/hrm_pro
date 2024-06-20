package com.hrm.hrm_pro.repository;

import com.hrm.hrm_pro.model.system_emp.BankEmp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BankEmpRepo extends JpaRepository<BankEmp, Integer> {
    @Query(value = "select a.emp_id,\n" +
            "       a.number,\n" +
            "       coalesce(a.code_unique, '') code_unique,\n" +
            "       coalesce(a.bank_block, '') bank_block,\n" +
            "       coalesce(a.bank_direct, '') bank_direct,\n" +
            "       coalesce(a.bank_dep, '') bank_dep,\n" +
            "       coalesce(a.bank_dep_insade, '') bank_dep_insade,\n" +
            "       coalesce(a.emp_position, '') emp_position,\n" +
            "       coalesce(a.emp_level, '') emp_level,\n" +
            "       coalesce(a.emp_manager, '') emp_manager,\n" +
            "       coalesce(a.sub_employee, '') sub_employee,\n" +
            "       coalesce(a.level_require, '') level_require,\n" +
            "       coalesce(a.emp_skill, '') emp_skill,\n" +
            "       coalesce(a.main_obligation, '') main_obligation,\n" +
            "       coalesce(a.func_desc, '') func_desc,\n" +
            "       coalesce(a.responsibility, '') responsibility,\n" +
            "       coalesce(a.emp_law, '') emp_law,\n" +
            "       coalesce(a.conf_direct_man1, '') conf_direct_man1,\n" +
            "       coalesce(a.conf_direct_level1, '') conf_direct_level1,\n" +
            "       coalesce(a.conf_direct_man2, '') conf_direct_man2,\n" +
            "       coalesce(a.conf_direct_man3, '') conf_direct_man3,\n" +
            "       coalesce(a.conf_direct_level2, '') conf_direct_level2,\n" +
            "       coalesce(a.conf_direct_man4, '') conf_direct_man4,\n" +
            "       coalesce(a.firstname, '') firstname,\n" +
            "       coalesce(a.lastname, '') lastname,\n" +
            "       coalesce(a.patronymic, '') patronymic,\n" +
            "       coalesce(a.creation_type, '') creation_type,\n" +
            "       a.create_date,\n" +
            "       coalesce(a.condition, '') condition from v_bank_emp a where \n" +
            " 'F' || a.emp_id || COALESCE(lower(a.firstname), '') || COALESCE(lower(a.lastname), '') || COALESCE(lower(a.patronymic), '') like %:filter%", nativeQuery = true)
    Page<BankEmp> getAllBankEmpPaging(Pageable pageable, String filter);

    @Query(value = "select new com.hrm.hrm_pro.model.system_emp.BankEmp(a.emp_id,\n" +
            "a.number,\n" +
            "COALESCE(a.code_unique, ''),\n" +
            "(select COALESCE(t1.name_ru, '') from BankBlock t1 where t1.code=a.bank_block), \n" +
            "(select COALESCE(t1.name_ru, '') from BankDirectorate t1 where t1.code=a.bank_direct), \n" +
            "(select COALESCE(t1.name_ru, '') from BankDepartment t1 where t1.code=a.bank_dep), \n" +
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
            "COALESCE(a.conf_direct_level1, ''), \n" +
            "COALESCE(a.conf_direct_man2, ''), \n" +
            "COALESCE(a.conf_direct_man3, ''), \n" +
            "COALESCE(a.conf_direct_level2, ''), \n" +
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
            "COALESCE(a.conf_direct_level1, ''), \n" +
            "COALESCE(a.conf_direct_man2, ''), \n" +
            "COALESCE(a.conf_direct_man3, ''), \n" +
            "COALESCE(a.conf_direct_level2, ''), \n" +
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
    BankEmp getBankEmpById(Integer emp_id);

    @Query("select count(a) from BankEmp a where a.condition = '1'")
    int getEmpCount();
}
