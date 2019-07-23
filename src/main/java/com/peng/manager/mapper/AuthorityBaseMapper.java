package com.peng.manager.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import packageModel.Authority;
/**
*  @author author
*/
public interface AuthorityBaseMapper {

    int insertAuthority(Authority object);

    int updateAuthority(Authority object);

    int update(Authority.UpdateBuilder object);

    List<Authority> queryAuthority(Authority object);

    Authority queryAuthorityLimit1(Authority object);

}