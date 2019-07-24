package com.peng.manager.mapper;

import java.util.List;

import com.peng.manager.domain.RoleAuthority;
import org.apache.ibatis.annotations.Param;
/**
*  @author author
*/
public interface RoleAuthorityBaseMapper {

    int insertRoleAuthority(RoleAuthority object);

    int updateRoleAuthority(RoleAuthority object);

    int update(RoleAuthority.UpdateBuilder object);

    List<RoleAuthority> queryRoleAuthority(RoleAuthority object);

    RoleAuthority queryRoleAuthorityLimit1(RoleAuthority object);

}