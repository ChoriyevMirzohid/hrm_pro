package com.hrm.hrm_pro.repository;

import com.hrm.hrm_pro.model.system_user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, Integer> {

}
