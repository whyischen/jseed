package com.whyischen.projectwebapp.controller;

import com.whyischen.projectwebapp.entity.User;
import com.whyischen.projectwebapp.mapper.UserMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserMapper userMapper;

    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @RequestMapping("/get")
    public User get() {
        return userMapper.getById(1L);
    }


}
