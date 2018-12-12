package com.peng.apply.mapper;

import com.peng.manager.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther: daipeng
 * @Date: 2018/10/31 19:42
 * @Description:
 */
public interface LoginMapper {
    /**
     * 根据用户名查询用户信息
     * @param name
     * @return User
     */
    User queryUserByName(@Param("name") String name);

    /**
     *根据手机号查询用户信息
     * @auther: daipeng
     * @date: 2018/11/1 上午10:41
     */
    User queryUserByPhone(@Param("phone") String phone);

    /**
     * 新增用户到数据库
     * @param user
     * @return
     */
    int saveUser(User user);

    User queryUserByEmail(@Param("email") String email);
}
