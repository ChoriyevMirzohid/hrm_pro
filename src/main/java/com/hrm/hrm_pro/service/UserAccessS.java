package com.hrm.hrm_pro.service;

import com.hrm.hrm_pro.repository.UserAccessRepo;
import org.springframework.stereotype.Service;

@Service
public class UserAccessS {
    final UserAccessRepo userAccessRepo;

    public UserAccessS(UserAccessRepo userAccessRepo) {
        this.userAccessRepo = userAccessRepo;
    }
}
