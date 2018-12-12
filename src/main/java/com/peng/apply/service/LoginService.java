package com.peng.apply.service;

import com.peng.common.ResultVo;
import com.peng.manager.domain.User;

/**
 * @Auther: daipeng
 * @Date: 2018/10/31 19:40
 * @Description:
 */
public interface LoginService {
    //根据用户名或者手机号查询用户信息
    ResultVo<String> queryUserByName(String userNameOrPhone);

    //注册用户到数据库
    ResultVo<String> registerUser(User user);

    //用户登陆
    ResultVo<String> loginUser(User user);
}
