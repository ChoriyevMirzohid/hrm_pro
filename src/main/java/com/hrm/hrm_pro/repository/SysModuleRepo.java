package com.hrm.hrm_pro.repository;

import com.hrm.hrm_pro.dto.SysModuleDto;
import com.hrm.hrm_pro.model.system_user.SysModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysModuleRepo extends JpaRepository<SysModule, Integer> {
    @Query("select new com.hrm.hrm_pro.dto.SysModuleDto(a.id, a.code, a.name_uz, a.name_ru, a.name_en, a.page_url, a.page_icon, a.page_type, a.condition, a.create_date) from SysModule a where a.condition='1' order by a.code")
    List<SysModuleDto> getAllSysModule();
}
