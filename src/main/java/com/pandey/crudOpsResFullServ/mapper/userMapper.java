package com.pandey.crudOpsResFullServ.mapper;

import com.pandey.crudOpsResFullServ.dto.userDto;
import com.pandey.crudOpsResFullServ.entity.user;

public class userMapper {
    public static user mapToUser(userDto userdto){
        user us=new user(userdto.getId(),userdto.getFirstName(),userdto.getLastName(),userdto.getEmail());
        return us;
    }
    public static userDto mapToUserdto(user user){
        userDto user1=new userDto(user.getId(), user.getFirstName(),user.getLastName(),user.getEmail());
        return user1;
    }
}
