package com.csii.userservice.controller;

import com.csii.userservice.entity.User;
import com.csii.userservice.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author cuitao
 * @version V1.0
 * @Description: ${todo}
 * @date 2018/8/25 - 13:28 -- 星期六
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/save/{age}/{name}")
    public String saveUser(@PathVariable int age,@PathVariable String name){
        User user = new User();
        user.setAge(age);
        user.setName(name);
        if(userMapper.saveUser(user)!=null){
            return "save user success!";
        }else{
            return "save user failed!";
        }
    }

    @GetMapping(value = "/get/{id}")
    public User getUserById(@PathVariable int id){
        return userMapper.selectById(id);
    }

}
