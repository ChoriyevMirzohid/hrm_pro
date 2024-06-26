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
            "       a.employment_date, \n" +
            "       a.create_date,\n" +
            "       coalesce(a.condition, '') condition," +
            "       a.block_id," +
            "       a.direct_id," +
            "       a.depart_id," +
            "       a.position_id," +
            "       a.level_id from v_bank_emp a where \n" +
            " 'F' || a.emp_id || COALESCE(lower(a.firstname), '') || COALESCE(lower(a.lastname), '') || COALESCE(lower(a.patronymic), '') like %:filter%", nativeQuery = true)
    Page<BankEmp> getAllBankEmpPaging(Pageable pageable, String filter);

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
            "       a.employment_date, \n" +
            "       a.create_date,\n" +
            "       coalesce(a.condition, '') condition," +
            "       a.block_id," +
            "       a.direct_id," +
            "       a.depart_id," +
            "       a.position_id," +
            "       a.level_id from v_bank_emp a where \n" +
            "       a.emp_id=:emp_id", nativeQuery = true)
    BankEmp getBankEmpById(Integer emp_id);

    @Query("select count(a) from BankEmp a where a.condition = '1'")
    int getEmpCount();
}
