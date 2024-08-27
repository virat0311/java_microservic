package com.pandey.crudOpsResFullServ.controller;

import com.pandey.crudOpsResFullServ.dto.userDto;
import com.pandey.crudOpsResFullServ.entity.user;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pandey.crudOpsResFullServ.repository.userRepository;
import com.pandey.crudOpsResFullServ.service.userService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class userController {
    private userService userService;
    //create resst Api to create user
    @PostMapping("/create")//here we are mapping entiry object into dto and viceversa using mapper calass so this is not good practice
    //in real world we use third pary mapper class to map
    //will learn third party library to map dto and entity 1)model mapper and 2)mapstruct
    public ResponseEntity<userDto> createUserBy(@Valid @RequestBody userDto user){
       userDto save=userService.createUser(user);
       return new ResponseEntity<>(save,HttpStatus.CREATED);
    }//localhost:8080/api/users/get/2
    @GetMapping("/get/{id}")
    public ResponseEntity<userDto> getUserbyId(@PathVariable("id") long userId){
        userDto get=userService.getUserById(userId);
        return new ResponseEntity<>(get,HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<userDto>> getAlluser(){
        List<userDto>l2= userService.getUser();
        return new ResponseEntity<>(l2,HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<userDto> udateUser(@PathVariable("id")Long id,@Valid @RequestBody userDto user){
        user.setId(id);
        userDto c=userService.updateById(user);
        return new ResponseEntity<>(c,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        userService.deleteById(id);
        return new ResponseEntity("deleted",HttpStatus.OK);
    }

}
