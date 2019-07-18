package com.peng.apply.service.impl;

import com.peng.apply.mapper.LoginMapper;
import com.peng.apply.service.LoginService;
import com.peng.common.CodeConstants;
import com.peng.common.ResultVo;
import com.peng.manager.domain.User;
import com.peng.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: daipeng
 * @Date: 2018/10/31 19:41
 * @Description:
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    /**
     * 根据用户名或者手机号查询用户信息
     * @param userNameOrPhone
     * @return
     */
    @Override
    public ResultVo<String> queryUserByName(String userNameOrPhone) {
        String flag = "";
        User user = null;
        //校验是用户名还是手机号
        Matcher isPhone = Pattern.compile(CodeConstants.PHONE_REG).matcher(userNameOrPhone);
        if(!isPhone.matches()){
            //是用户名
            user = loginMapper.queryUserByName(userNameOrPhone);
            flag = "用户名";
        }else {
            //手机号
            user = loginMapper.queryUserByPhone(userNameOrPhone);
            flag = "手机号";
        }


        if(null == user){
            //用户名不存在 可以注册
            return ResultVo.success("恭喜你 当前"+flag+"可以注册");
        }

        //用户名已存在不可注册
        return ResultVo.success(CodeConstants.NAME_EXIST,flag+"已存在请更换");

    }


    /**
     * 注册用户到数据库
     * @param user
     * @return
     */
    @Override
    @Transactional
    public ResultVo<String> registerUser(User user) {

        // FIXME: 2018/11/1 再次校验用户名 和手机号

        //用户名
       User dbUser = loginMapper.queryUserByName(user.getName());
       if(null != dbUser){
           //注册失败
           return ResultVo.error(CodeConstants.NAME_EXIST,"注册失败 请检查用户名或手机号");
       }
        //手机号
        dbUser = loginMapper.queryUserByPhone(user.getPhone());
        if(null != dbUser){
            //注册失败
            return ResultVo.error(CodeConstants.NAME_EXIST,"注册失败 请检查用户名或手机号");
        }

        //密码加密
        user.setPassword(MD5.md5(user.getPassword()));

        int id = loginMapper.saveUser(user);
        if(id == 0){
            //注册失败
            return ResultVo.error(CodeConstants.REG_ERROR,"注册失败 请稍后重试");
        }
        return ResultVo.success("注册成功");

    }

    /**
     *  用户登陆
     * @param:
     * @return:
     * @auther: daipeng
     * @date: 2018/11/5 下午7:52
     */
    @Override
    public ResultVo<String> loginUser(User user, HttpServletRequest request) {
        //校验是用户名还是手机号
        Matcher isPhone = Pattern.compile(CodeConstants.PHONE_REG).matcher(user.getName());
        Matcher isEmail = Pattern.compile(CodeConstants.EMAIL_REG).matcher(user.getName());
        Matcher isUserName = Pattern.compile(CodeConstants.NAME_REG).matcher(user.getName());
        User dbUser = null;
        if(isPhone.matches()){
            //手机号
            dbUser = loginMapper.queryUserByPhone(user.getName());
        }else if(isEmail.matches()){
            //邮箱
            dbUser = loginMapper.queryUserByEmail(user.getName());
        }else if(isUserName.matches()){
            //用户名
            dbUser = loginMapper.queryUserByName(user.getName());
        }


        if(null == dbUser){
            //用户名不存在 用户名或者密码错误
            return ResultVo.error(CodeConstants.REG_ERROR,"用户名或者密码错误，请重试");
        }


        //校验密码
        user.setPassword(MD5.md5(user.getPassword()));
        if(!user.getPassword().equals(dbUser.getPassword())){
            //密码错误 用户名或者密码错误
            return ResultVo.error(CodeConstants.REG_ERROR,"用户名或者密码错误，请重试");
        }


        //登陆成功 将用户信息存放到session中
        request.getSession().setAttribute("user",dbUser);


        return ResultVo.success("登陆成功！！!");
    }
}
