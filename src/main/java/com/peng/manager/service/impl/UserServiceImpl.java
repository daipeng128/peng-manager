package com.peng.manager.service.impl;

import com.peng.manager.domain.User;
import com.peng.manager.mapper.UserMapper;
import com.peng.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryUserList() {
        return userMapper.queryUserList();
    }
}
