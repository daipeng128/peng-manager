package com.peng.manager.service;

import com.peng.manager.domain.UserRole;
import com.peng.manager.domain.UserRoleVo;

import java.util.List;

/**
 * @Auther: daipeng
 * @Date: 2019/7/18 22:05
 * @Description:
 */
public interface UserRoleService {

    List<UserRole> queryUserRoleList(Integer userId);


    String setRolesToUser(Integer userId, Integer[] roleIds);
}
