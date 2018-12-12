package com.peng.common;

import java.io.StringReader;

/**
 * @author zhushuaixing on 2017/9/25
 */
public class CodeConstants {
    //用户名或者手机号已存在
    public static final Integer NAME_EXIST = 50001;
    //注册失败
    public static final Integer REG_ERROR = 50002;
    //用户名或者密码错误
    public static final Integer USER_ERROR = 50003;

    //用户名正则
    public static final String NAME_REG = "(?!_)(?!.*?_$)[a-zA-Z0-9_\\u4e00-\\u9fa5]{4,20}";
    //手机号正则
    public static final String PHONE_REG = "1[34578]\\d{9}";
    //邮箱正则
    public static final String EMAIL_REG = "[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,4}";
}
