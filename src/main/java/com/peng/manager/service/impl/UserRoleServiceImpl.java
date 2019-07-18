package com.peng.manager.service.impl;

import com.peng.manager.domain.UserRole;
import com.peng.manager.mapper.UserRoleMapperMapper;
import com.peng.manager.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: daipeng
 * @Date: 2019/7/18 22:16
 * @Description:
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapperMapper userRoleMapperMapper;

    @Override
    public List<UserRole> queryUserRoleList(Integer userId) {

        List<UserRole> userRoleList = userRoleMapperMapper.queryUserRoleList(userId);
        return userRoleList;
    }
}
