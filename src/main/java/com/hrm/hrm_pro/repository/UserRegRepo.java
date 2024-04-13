package com.hrm.hrm_pro.repository;

import com.hrm.hrm_pro.dto.UserRegDto;
import com.hrm.hrm_pro.model.system_user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegRepo extends JpaRepository<User, Integer> {
    @Query("select new com.hrm.hrm_pro.dto.UserRegDto(a.id, a.fullname, a.email, a.login, a.password, a.condition, a.create_date, a.delete_date) from User a order by a.create_date desc")
    Page<UserRegDto> getAllUsersPaging(Pageable pageable);
}
