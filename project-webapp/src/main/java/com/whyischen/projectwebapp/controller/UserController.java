package com.whyischen.projectwebapp.controller;

import com.whyischen.projectwebapp.entity.User;
import com.whyischen.projectwebapp.mapper.UserMapper;
import com.whyischen.projectwebapp.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserController(UserMapper userMapper,
                          UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @RequestMapping("/get")
    public User get1() {
        return userMapper.getById(1L);
    }

    @RequestMapping("/get2")
    public User get2() {
        return userRepository.findById(1L).get();
//        return userRepository.findAll().get(0);
    }

}
