package com.hrm.hrm_pro.repository;

import com.hrm.hrm_pro.dto.RoleDto;
import com.hrm.hrm_pro.dto.UserRegDto;
import com.hrm.hrm_pro.model.system_user.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRegRepo extends JpaRepository<UserEntity, Integer> {
    @Query("select new com.hrm.hrm_pro.dto.UserRegDto(a.id, a.firstname, a.lastname, a.patronymic, a.email, a.login, a.password, (select r.role_code from UserRole r where a.id=r.user_id), a.condition, a.create_date, a.delete_date) from UserEntity a order by a.create_date desc")
    Page<UserRegDto> getAllUsersPaging(Pageable pageable);

    @Query(nativeQuery = true, value = "select * from users a where a.condition='1' and a.login=:login")
    UserEntity findByLoginQ(String login);

    @Query("select new com.hrm.hrm_pro.dto.RoleDto(a.id, a.code, a.name, a.title) from Role a order by a.code")
    List<RoleDto> getAllRole();

    @Query("select new com.hrm.hrm_pro.dto.UserRegDto(a.id, a.firstname, a.lastname, a.patronymic, a.email, a.login, a.password, (select r.role_code from UserRole r where a.id=r.user_id), a.condition, a.create_date, a.delete_date) from UserEntity a where a.login=:username")
    UserRegDto getUserById(String username);
}
