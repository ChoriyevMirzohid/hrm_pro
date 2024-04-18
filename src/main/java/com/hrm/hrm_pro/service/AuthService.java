package com.hrm.hrm_pro.service;

import com.hrm.hrm_pro.model.system_user.UserEntity;
import com.hrm.hrm_pro.repository.UserRegRepo;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    final UserRegRepo userRegRepo;

    public AuthService(UserRegRepo userRegRepo) {
        this.userRegRepo = userRegRepo;
    }

    public boolean loginPasswordCheck(String login, String password){
        UserEntity userEntity = userRegRepo.findByLoginQ(login);
        boolean check = false;
        if (userEntity != null){
            String passwordData = userEntity.getPassword();
            check = passwordData.equals(password);
        }
        return check;
    }
}
