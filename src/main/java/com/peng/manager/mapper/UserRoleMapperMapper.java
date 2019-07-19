package com.peng.manager.mapper;

import com.peng.manager.domain.UserRole;
import com.peng.manager.mapper.UserRoleMapperBaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
*  @author author
*/
public interface UserRoleMapperMapper extends UserRoleMapperBaseMapper{

    List<UserRole> queryUserRoleList(@Param("userId") Integer userId);

    //根据用户id 失效之前的数据
    void forbidUserRoleByUserId(@Param("userId") Integer userId);

    void setUserRole(@Param("userId") Integer userId,
                     @Param("roleIds") Integer[] roleIds);
}