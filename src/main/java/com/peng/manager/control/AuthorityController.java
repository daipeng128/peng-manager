package com.peng.manager.control;

import com.peng.manager.domain.AuthoriytTree;
import com.peng.manager.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Auther: daipeng
 * @Date: 2019/7/20 14:24
 * @Description:
 */
@Controller
@RequestMapping("authority")
public class AuthorityController {

    @Autowired
    private AuthorityService authorityService;


    @RequestMapping("openAuthorityPage")
    public ModelAndView queryRoleList(String roleName){


        ModelAndView modelAndView = new ModelAndView("authority/authority-tree");

        return modelAndView;
    }

    @RequestMapping("openAuthoritySetPage")
    public ModelAndView openAuthoritySetPage(String roleName){


        ModelAndView modelAndView = new ModelAndView("authority/authority-tree-set");

        return modelAndView;
    }


    @RequestMapping("queryAuthorityTree")
    @ResponseBody
    public List<AuthoriytTree> queryAuthorityTree(){

        return authorityService.queryAuthorityTree();
    }


}
