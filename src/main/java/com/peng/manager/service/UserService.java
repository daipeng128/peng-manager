package com.peng.manager.service;


import com.peng.manager.domain.User;

import java.util.List;

public interface UserService {

    //查询用户列表
    List<User> queryUserList();
}
