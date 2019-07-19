package com.peng.manager.service.impl;

import com.peng.manager.domain.UserRole;
import com.peng.manager.mapper.UserRoleMapperMapper;
import com.peng.manager.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: daipeng
 * @Date: 2019/7/18 22:16
 * @Description:
 */
@Service
@Slf4j
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapperMapper userRoleMapperMapper;

    @Override
    public List<UserRole> queryUserRoleList(Integer userId) {

        List<UserRole> userRoleList = userRoleMapperMapper.queryUserRoleList(userId);
        return userRoleList;
    }

    @Override
    public String setRolesToUser(Integer userId, Integer[] roleIds) {
        log.info("用户:{},roleId:{}",userId,roleIds);

        //用户id先根据用户id 将之前的数据 失效掉
        userRoleMapperMapper.forbidUserRoleByUserId(userId);

        //赋值新的角色权限
        userRoleMapperMapper.setUserRole(userId,roleIds);


        return "角色赋值成功！！！";
    }
}
