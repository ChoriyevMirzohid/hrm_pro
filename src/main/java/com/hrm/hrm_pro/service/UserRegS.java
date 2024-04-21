package com.hrm.hrm_pro.service;

import com.hrm.hrm_pro.dto.PagingResponse;
import com.hrm.hrm_pro.dto.RoleDto;
import com.hrm.hrm_pro.dto.UserRegDto;
import com.hrm.hrm_pro.model.system_user.UserEntity;
import com.hrm.hrm_pro.model.system_user.UserRole;
import com.hrm.hrm_pro.repository.UserRegRepo;
import com.hrm.hrm_pro.repository.UserRoleRepo;
import com.hrm.hrm_pro.utils.Utils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserRegS {
    final
    UserRegRepo userRegRepo;
    final UserRoleRepo userRoleRepo;

    public UserRegS(UserRegRepo userRegRepo, UserRoleRepo userRoleRepo) {
        this.userRegRepo = userRegRepo;
        this.userRoleRepo = userRoleRepo;
    }

    public void save(UserRegDto userRegDto) {
        UserEntity user = new UserEntity();
        user.setFirstname(userRegDto.getFirstname());
        user.setLastname(userRegDto.getLastname());
        user.setPatronymic(userRegDto.getPatronymic());
        user.setEmail(userRegDto.getEmail());
        user.setCondition(userRegDto.getCondition());
        user.setLogin(userRegDto.getLogin());
        user.setPassword(Utils.getMd5(userRegDto.getPassword()));

        user = userRegRepo.save(user);

        UserRole userRole = new UserRole();
        userRole.setRole_code(userRegDto.getRole_code());
        userRole.setCondition(String.valueOf('1'));
        userRole.setUser_id(user.getId());
        userRoleRepo.save(userRole);
    }

    public PagingResponse getAllUsersPaging(int pageNum, int pageSize) {
        if (pageNum < 0){
            pageNum = 0;
        }
        if (pageSize <= 0){
            pageSize = 10;
        }
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<UserRegDto> userRegDtoPage = userRegRepo.getAllUsersPaging(pageable);
        List<?> usersList = userRegDtoPage.stream().toList();

        PagingResponse pagingResponse = new PagingResponse();
        pagingResponse.setContent(usersList);
        pagingResponse.setPageNum(userRegDtoPage.getNumber());
        pagingResponse.setPageSize(userRegDtoPage.getSize());
        pagingResponse.setTotalPages(userRegDtoPage.getTotalPages());
        pagingResponse.setTotalElements(userRegDtoPage.getTotalElements());
        pagingResponse.setLast(userRegDtoPage.isLast());

        return pagingResponse;
    }

    public List<RoleDto> getAllRole(){
        return userRegRepo.getAllRole();
    }

    public UserRegDto getUserById(String username) {
        return userRegRepo.getUserById(username);
    }
}
