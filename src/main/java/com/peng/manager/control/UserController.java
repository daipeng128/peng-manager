package com.peng.manager.control;


import com.peng.manager.domain.User;
import com.peng.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("queryUserList")
    public ModelAndView queryUserList(){

       List<User> userList = userService.queryUserList();


        ModelAndView modelAndView = new ModelAndView("user/user-list");
        modelAndView.addObject("userList",userList);

        return modelAndView;
    }
}
