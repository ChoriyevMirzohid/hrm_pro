package com.hrm.hrm_pro.service;

import com.hrm.hrm_pro.dto.UserRegDto;
import com.hrm.hrm_pro.model.system_user.UserEntity;
import com.hrm.hrm_pro.repository.UserRegRepo;
import com.hrm.hrm_pro.utils.Utils;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    final UserRegRepo userRegRepo;
    final UserRegS userRegS;

    public AuthService(UserRegRepo userRegRepo, UserRegS userRegS) {
        this.userRegRepo = userRegRepo;
        this.userRegS = userRegS;
    }

    public boolean loginPasswordCheck(String login, String password){
        UserEntity userEntity = userRegRepo.findByLoginQ(login);
        boolean check;
        if (userEntity != null){
            String passwordData = userEntity.getPassword();
            check = passwordData.equals(Utils.getMd5(password));
        }else{
            check =
                    login.equals("HRAdmin@ipotekabank.uz") &&
                            password.equals("Qwerty+-");
            if (check){
                UserEntity userEntity1 = userRegRepo.findByLoginQ(login);
                if (userEntity1==null){
                    UserRegDto user = new UserRegDto();
                    user.setPatronymic("HRM Admin");
                    user.setFirstname("HRM Admin");
                    user.setLastname("HRM Admin");
                    user.setLogin("HRAdmin@ipotekabank.uz");
                    user.setEmail("HRAdmin@ipotekabank.uz");
                    user.setPassword("Qwerty+-");
                    user.setCondition("1");
                    user.setRole_code(3);
                    userRegS.save(user);
                }
            }
        }
        return check;
    }
}
