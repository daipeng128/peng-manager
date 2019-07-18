package com.peng.manager.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.peng.manager.domain.UserRole;
/**
*  @author author
*/
public interface UserRoleMapperBaseMapper {

    int insertUserRole(UserRole object);

    int updateUserRole(UserRole object);

    int update(UserRole.UpdateBuilder object);

    List<UserRole> queryUserRole(UserRole object);

    UserRole queryUserRoleLimit1(UserRole object);

}