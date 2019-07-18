package com.peng.manager.service.impl;

import com.peng.manager.domain.Role;
import com.peng.manager.mapper.RoleMapperBaseMapper;
import com.peng.manager.mapper.RoleMapperMapper;
import com.peng.manager.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: daipeng
 * @Date: 2019/7/18 21:03
 * @Description:
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapperBaseMapper roleMapperBaseMapper;

    @Autowired
    private RoleMapperMapper roleMapperMapper;


    @Override
    public List<Role> queryRoleList(String roleName) {

        Role role = new Role();

        role.setRole(roleName);

        List<Role> roleList = roleMapperBaseMapper.queryRole(role);
        return roleList;
    }
}
