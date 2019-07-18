package com.peng.manager.mapper;

import java.util.List;

import com.peng.manager.domain.Role;
/**
*  @author author
*/
public interface RoleMapperBaseMapper {

    int insertRole(Role object);

    int updateRole(Role object);

    int update(Role.UpdateBuilder object);

    List<Role> queryRole(Role object);

    Role queryRoleLimit1(Role object);

}