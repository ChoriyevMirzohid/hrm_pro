package com.hrm.hrm_pro.repository;

import com.hrm.hrm_pro.dto.BankDepartmentDto;
import com.hrm.hrm_pro.model.system_emp.BankDepartment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankDepartmentRepo extends JpaRepository<BankDepartment, Integer> {
    @Query("select new com.hrm.hrm_pro.dto.BankDepartmentDto(a.id, a.code, a.directorate_id, a.name_uz, a.name_ru, a.name_en, a.deputy_id, a.condition, a.create_date, a.delete_date) from BankDepartment a order by a.code")
    Page<BankDepartmentDto> getAllBankDepartmentPaging(Pageable pageable);

    @Query("select new com.hrm.hrm_pro.dto.BankDepartmentDto(a.id, a.code, a.directorate_id, a.name_uz, a.name_ru, a.name_en, a.deputy_id, a.condition, a.create_date, a.delete_date) from BankDepartment a where a.directorate_id=:directorate_id order by a.code")
    Page<BankDepartmentDto> getAllBankDepartmentPaging(Pageable pageable, Integer directorate_id);

    @Query("select new com.hrm.hrm_pro.dto.BankDepartmentDto(a.id, a.code, a.directorate_id, a.name_uz, a.name_ru, a.name_en, a.deputy_id, a.condition, a.create_date, a.delete_date) from BankDepartment a where a.condition='1' order by a.code")
    List<BankDepartmentDto> getAllBankDepartment();

    @Query("select new com.hrm.hrm_pro.dto.BankDepartmentDto(a.id, a.code, a.directorate_id, a.name_uz, a.name_ru, a.name_en, a.deputy_id, a.condition, a.create_date, a.delete_date) from BankDepartment a where a.id=:id and a.condition='1' order by a.code")
    BankDepartmentDto getBankDepartmentById(Integer id);

    @Query("select count(a) from BankDepartment a where a.condition='1'")
    int getDepartCount();
}
