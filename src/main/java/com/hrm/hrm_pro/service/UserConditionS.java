package com.hrm.hrm_pro.service;

import com.hrm.hrm_pro.model.system_user.UserCondition;
import com.hrm.hrm_pro.repository.UserConditionRepo;
import org.springframework.stereotype.Service;

@Service
public class UserConditionS {
    final
    UserConditionRepo userConditionRepo;

    public UserConditionS(UserConditionRepo userConditionRepo) {
        this.userConditionRepo = userConditionRepo;
    }

    public String getConditionName(String code){
        UserCondition userCondition = userConditionRepo.findByCode(code);
        return userCondition.getCode() + "-" + userCondition.getName();
    }
}
