package com.peng.manager.domain;

import lombok.Data;

/**
 * @Auther: daipeng
 * @Date: 2019/7/18 22:06
 * @Description:
 */
@Data
public class UserRoleVo extends Role {

    // 用户是否拥有当前角色
    private Integer flag;


    /**
     * 用户表主键
     * isNullAble:0
     */
    private Integer userId;

    /**
     * 角色表主键
     * isNullAble:0
     */
    private Integer roleId;


}
