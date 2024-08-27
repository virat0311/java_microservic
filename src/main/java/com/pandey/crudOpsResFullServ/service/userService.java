package com.pandey.crudOpsResFullServ.service;
import com.pandey.crudOpsResFullServ.dto.userDto;
import com.pandey.crudOpsResFullServ.entity.user;

import java.util.List;

public interface userService {
         userDto createUser(userDto user);
         userDto getUserById(Long userId);
         List<userDto> getUser();
         userDto updateById(userDto user);
        void deleteById(Long id);
}
