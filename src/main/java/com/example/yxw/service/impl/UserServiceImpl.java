package com.example.yxw.service.impl;

import com.example.yxw.dao.UserMapper;
import com.example.yxw.domain.User;
import com.example.yxw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserByName(String username) {
        return userMapper.selectUserByName(username);
    }
}
