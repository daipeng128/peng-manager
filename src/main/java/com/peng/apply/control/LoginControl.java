package com.peng.apply.control;

import com.peng.config.KafkaConfig;
import com.peng.apply.service.LoginService;
import com.peng.common.ResultVo;
import com.peng.manager.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ExecutionException;

/**
 * @Auther: daipeng
 * @Date: 2018/10/30 19:57
 * @Description:
 */
@Controller
@RequestMapping("/login")
public class LoginControl {


    @Autowired
    private LoginService loginService;

    /**
     *  打开注册页面
     * @auther: daipeng
     * @date: 2018/10/31 下午1:03
     */
    @RequestMapping(value = "/openRegisterPage",method = RequestMethod.GET)
    public ModelAndView openRegisterPage(){
        ModelAndView view = new ModelAndView();
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
                                      @RequestParam("password") String password,
                                      HttpServletRequest request){
       return loginService.loginUser(new User(name,password,null),request);
    }



    //使用spring-kafka的template发送一条消息 发送多条消息只需要循环多次即可
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(KafkaConfig.class);
        KafkaTemplate<Integer, String> kafkaTemplate = (KafkaTemplate<Integer, String>) ctx.getBean("kafkaTemplate");
        String data="this is a test message";
        ListenableFuture<SendResult<Integer, String>> send = kafkaTemplate.send("topic-test", 1, data);
        send.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            public void onFailure(Throwable throwable) {

            }

            public void onSuccess(SendResult<Integer, String> integerStringSendResult) {

            }
        });
    }
}
