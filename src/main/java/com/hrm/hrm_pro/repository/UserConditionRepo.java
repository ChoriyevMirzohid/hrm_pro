package com.hrm.hrm_pro.repository;

import com.hrm.hrm_pro.model.system_user.UserCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserConditionRepo extends JpaRepository<UserCondition, Integer> {

}
