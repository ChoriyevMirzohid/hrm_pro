package com.hrm.hrm_pro.repository;

import com.hrm.hrm_pro.dto.EmpLevelDto;
import com.hrm.hrm_pro.model.system_emp.EmpLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpLevelRepo extends JpaRepository<EmpLevel, Integer> {
    @Query("select new com.hrm.hrm_pro.dto.EmpLevelDto(a.id, a.level_code, a.name_uz, a.name_ru, a.name_en, a.condition, a.create_date, a.delete_date) from EmpLevel a order by a.create_date desc")
    Page<EmpLevelDto> getAllEmpLevelPaging(Pageable pageable);

    @Query("select new com.hrm.hrm_pro.dto.EmpLevelDto(a.id, a.level_code, a.name_uz, a.name_ru, a.name_en, a.condition, a.create_date, a.delete_date) from EmpLevel a order by a.level_code")
    List<EmpLevelDto> getAllEmpLevel();
}
