package com.pandey.crudOpsResFullServ.service.impl;

import com.pandey.crudOpsResFullServ.entity.user;
import com.pandey.crudOpsResFullServ.exception.resourceNotFoundExcep;
import com.pandey.crudOpsResFullServ.mapper.userMapper;
import com.pandey.crudOpsResFullServ.service.userService;
import com.pandey.crudOpsResFullServ.repository.userRepository;
import com.pandey.crudOpsResFullServ.dto.userDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.pandey.crudOpsResFullServ.mapper.userMapper.mapToUser;
import static com.pandey.crudOpsResFullServ.mapper.userMapper.mapToUserdto;

@Service
@AllArgsConstructor
public class userServiceImp implements userService {
    private ModelMapper modelMapper;
    private userRepository userRepository;
    public userDto createUser(userDto userDto) {
        //coming paramerter is in dto so convert into user entity and then after we use modelmapper third party to map dto to user
        //2 user user1=mapToUser(userDto);
        user user1=modelMapper.map(userDto,user.class);// destinatio type always in .class extension
         user user=userRepository.save(user1);
         //convert again to dto of user2 and then again modelmapper to convert user to dto
        //2   userDto user3=mapToUserdto(user);
        userDto user3=modelMapper.map(user,userDto.class);// destinatio type always in .class extension
        return user3;

    }

    @Override//here we created exception class to send our exception to client
    public userDto getUserById(Long userId) {
//   3     optional<user> a=userRepository.findById(userId);
        user a= userRepository.findById(userId).orElseThrow(
                ()->new resourceNotFoundExcep("user","id",userId)
        );
        //2  return mapToUserdto(a.get());
        return modelMapper.map(a, userDto.class);
    }

    @Override
    public List<userDto> getUser() {
        List<user> l1=new ArrayList<>();
        l1= userRepository.findAll();
//        return l1.stream().map(userMapper::mapToUserdto).collect(Collectors.toList());
        return l1.stream().map((user)->modelMapper.map(user, userDto.class)).collect(Collectors.toList());


    }

    @Override
    public userDto updateById(userDto user1) {
        //2 user a=mapToUser(user);
       //3 user b=userRepository.findById(user1.getId()).get();
        user b=userRepository.findById(user1.getId()).orElseThrow(
                ()->new resourceNotFoundExcep("user","id", user1.getId())
        );
        //userDto c=mapToUserdto(b);
        b.setFirstName(user1.getFirstName());
        b.setLastName(user1.getLastName());
        b.setEmail(user1.getEmail());
        user c=userRepository.save(b);
       //2 return mapToUserdto(c);
        return modelMapper.map(c, userDto.class);// destinatio type always in .class extension


    }

    @Override
    public void deleteById(Long id) {
        user b=userRepository.findById(id).orElseThrow(
                ()->new resourceNotFoundExcep("user","id", id)
        );
        userRepository.deleteById(id);

    }

}
