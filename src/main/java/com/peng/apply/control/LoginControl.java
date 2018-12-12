package com.peng.apply.control;

import com.peng.apply.service.LoginService;
import com.peng.common.ResultVo;
import com.peng.manager.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: daipeng
 * @Date: 2018/10/30 19:57
 * @Description:
 */
@Controller
@RequestMapping("/login")
public class LoginControl {

    //私有化返回页面参数对象
    private ModelAndView view = new ModelAndView();
    @Autowired
    private LoginService loginService;

    /**
     *  打开注册页面
     * @auther: daipeng
     * @date: 2018/10/31 下午1:03
     */
    @RequestMapping(value = "/openRegisterPage",method = RequestMethod.GET)
    public ModelAndView openRegisterPage(){
        view.setViewName("user/register-user");
        return view;
    }


    /**
     * 校验用户名或者手机号
     */
    @RequestMapping(value = "/checkUserNameOrPhone",method = {RequestMethod.GET})
    @ResponseBody
    public ResultVo<String> checkUserName(@RequestParam("userNameOrPhone") String userNameOrPhone){
        return loginService.queryUserByName(userNameOrPhone);
    }

    /**
     * 注册用户到数据库
     * @param name
     * @param password
     * @param phone
     * @return
     */
    @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
    @ResponseBody
    public ResultVo<String> registerUser(@RequestParam("name") String name,
                                         @RequestParam("password") String password,
                                         @RequestParam("phone") String phone){
       return loginService.registerUser(new User(name,password,phone));
    }

    /**
     * 用户登陆
     * @param name
     * @param password
     * @return
     */
    @RequestMapping(value = "/loginUser",method = RequestMethod.POST)
    @ResponseBody
    public ResultVo<String> loginUser(@RequestParam("name") String name,
                                         @RequestParam("password") String password){
       return loginService.loginUser(new User(name,password,null));
    }
}
