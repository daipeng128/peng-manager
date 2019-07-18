package com.peng.manager.service;

import com.peng.manager.domain.Role;

import java.util.List;

/**
 * @Auther: daipeng
 * @Date: 2019/7/18 21:02
 * @Description:
 */
public interface RoleService {

    /**
     * 获取所有角色
     * @return
     * @param roleName
     */
    List<Role> queryRoleList(String roleName);

}
