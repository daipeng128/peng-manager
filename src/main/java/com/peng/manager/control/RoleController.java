package com.peng.manager.control;

import com.peng.manager.domain.Role;
import com.peng.manager.domain.UserRole;
import com.peng.manager.domain.UserRoleVo;
import com.peng.manager.service.RoleService;
import com.peng.manager.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Auther: daipeng
 * @Date: 2019/7/18 21:02
 * @Description:
 */
@Controller
@RequestMapping("role")
public class RoleController {


    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;


    @RequestMapping("queryRoleList")
    public ModelAndView queryRoleList(String roleName){

        List<Role> userList = roleService.queryRoleList(roleName);

        ModelAndView modelAndView = new ModelAndView("role/role-list");
        modelAndView.addObject("roleList",userList);

        return modelAndView;
    }

    @RequestMapping("queryRoleList4Data")
    @ResponseBody
    public List<Role> queryRoleList4Data(String roleName){

        List<Role> userList = roleService.queryRoleList(roleName);

        return userList;
    }


    /**
     * 根据当前用户id 返回对应的角色
     * @param userId
     * @return
     */
    @RequestMapping("queryRoleListByUserId")
    @ResponseBody
    public List<UserRole> queryRoleList4Data(Integer userId){

        List<UserRole> userList = userRoleService.queryUserRoleList(userId);

        return userList;
    }

}
