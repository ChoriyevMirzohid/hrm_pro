package com.hrm.hrm_pro.service;

import com.hrm.hrm_pro.dto.PagingResponse;
import com.hrm.hrm_pro.dto.UserRegDto;
import com.hrm.hrm_pro.model.system_user.User;
import com.hrm.hrm_pro.repository.UserRegRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserRegS {
    final
    UserRegRepo userRegRepo;

    public UserRegS(UserRegRepo userRegRepo) {
        this.userRegRepo = userRegRepo;
    }

    public void save(UserRegDto userRegDto) {
        User user = new User();
        user.setFullname(userRegDto.getFullname());
        user.setEmail(userRegDto.getEmail());
        user.setCondition(userRegDto.getCondition());
        user.setLogin(userRegDto.getLogin());
        user.setPassword(userRegDto.getPassword());
        userRegRepo.save(user);
    }

    public List<UserRegDto> getAllUsers() {
        return userRegRepo.getAllUsers();
    }

    public PagingResponse getAllUsersPaging(int pageNum, int pageSize) {
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

    public UserRegDto getUserById(Integer id){
        return userRegRepo.getUserById(id);
    }
}
