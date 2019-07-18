package com.peng.apply.control;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
public class PayController {

    private final String APP_ID = "2016092600602781";
    private final String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCCPeoUqe7inp0P1lMxdlch3cRHdTOikJ+xCVsXH8Y52hSolqftVnyIjhjuoLNrWKkv2ctpRG6z1IHhYqi/fG56wGyqmfXJpqNiWrFd0pdr0x7wTpHTtE01BNccy1dFjYJbcYWS/vXL06BPpkFigCNaUhduEtA9Izupqzi8mPZupXR+MshNQsjRfnI3BK5KG5BWFKgrVVxleolo3u5rr3wDzY6cfLW02ucpy2K6BCwn/heuMEWbgXmCwn08UseiF5fjQRyLQ4+yAUBeAUQwOVMVb/p62gKsEnEjzWMeH5Sq8tXBsM4TA21kidyNV3s2SGKFN+748UaaiWHfST3O5cA7AgMBAAECggEAdYwF0YKRrQz0uk94pGKnP1SVCt1XrfgTeMf144f080/FZ2cZxpZRLTn6fJyjclYB1MMf2DFALKO2WUIfBTv7xmQXb14nPElemq05+XDQ4ysXeFGhQc4wBJMKxt0rNgYCyh9KLCJamwy0Wk62In196s2+gcUPFq7O8VIskeMIP1FXjGg/IwvsW2onulvbwH+/sb/QIC+XJmzqduSPoUk5v3GM2eyWIqEuC/km4IL5aRjpKytGKxHHvrdviF4YJhMtw28wOO4VC018QdEQczZqn3AL6kOzsRRtLLZrPmCjIWDSOv/Lh+tFNF6MbjFAtgKUHVnLhm/enkTj4hCZNF2yWQKBgQDpmDibqxJu+Js5+vtpkG+ID+osiNQRFETmnI7Y0LEostl8uIOlVdi++BCQZfkJepgXc47W4M1iZMHFzqzVi+YwIgmCCHCwdF2GctEyp3G0P9IYgyf+VxS2Mo23vOyJ8dcmIlUbk8pY0NA2eAX/d7JP2zfDOsyX8G3SwZ4mHeKtZQKBgQCOu+1AtK6wfTIQLRj5d7FoLETeB1vLZJTjYLeil6lW9AZEoFCcjkqBknyjA/ZRX1T7WdjQFl4WnyR4MAo94Ppoz/5OUuS/O7CMP26StUpAHZoyrzTbxTricIi/skpQ4pRrM3ofBRGhMDqI4ylvsshJU+LDJUvge+3w0mbClJgtHwKBgQDNlD71mTgO29JY066huBDAESmJah4grdL5lf0NiZTweX54ijapsoSfhNenDWd/1Rm3QecK6ys2FfCHMp3fDlFWOQ5fFyh90ttgcPn1d3HVLXmsQvlWmLLMqm8YrjcKLAGqOPrn20hwo80qsrSsoV4Xc5l+wue+LEWq/uU9LH4LFQKBgHRKwR77F2lMV8G+PJ7k2nJZvzJ3JF8u7+/iGTwr/RiPcZvwUj174VB4nXvj+oiJ959isLe5wacEup4B5hZMezlyXWxLNXxpkYpzFBAMDRb4B25MOfDlXPipX4FwLgSA1xQQuOsVIiwGM2rcSiJrs6uq4RLGDHA2CMMxafAXSXVZAoGAa25KTbsFd9LhbwIznWLVn8+lYIxUv726Z0uUIOBlvjvp+Skk7H9sdQqUBfV6MztZcUvztMaxOLoLKhPXEcxkWNNzSGMHy1ag8WKdZIeBAJtLxjgG/TGUDuUP6lZBD8JKOZRjsWL+SrGLssYD5YRCUv3CbJ4xm0cF++Kx7Hz+O5Q=";
    private final String CHARSET = "UTF-8";
    private final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgj3qFKnu4p6dD9ZTMXZXId3ER3UzopCfsQlbFx/GOdoUqJan7VZ8iI4Y7qCza1ipL9nLaURus9SB4WKov3xuesBsqpn1yaajYlqxXdKXa9Me8E6R07RNNQTXHMtXRY2CW3GFkv71y9OgT6ZBYoAjWlIXbhLQPSM7qas4vJj2bqV0fjLITULI0X5yNwSuShuQVhSoK1VcZXqJaN7ua698A82OnHy1tNrnKctiugQsJ/4XrjBFm4F5gsJ9PFLHoheX40Eci0OPsgFAXgFEMDlTFW/6etoCrBJxI81jHh+UqvLVwbDOEwNtZIncjVd7NkhihTfu+PFGmolh30k9zuXAOwIDAQAB\n";
    //这是沙箱接口路径,正式路径为https://openapi.alipay.com/gateway.do
    private final String GATEWAY_URL ="https://openapi.alipaydev.com/gateway.do";
    private final String FORMAT = "JSON";
    //签名方式
    private final String SIGN_TYPE = "RSA2";
    //支付宝异步通知路径,付款完毕后会异步调用本项目的方法,必须为公网地址
    private final String NOTIFY_URL = "http://公网地址/notifyUrl";
    //支付宝同步通知路径,也就是当付款完毕后跳转本项目的页面,可以不是公网地址
    private final String RETURN_URL = "http://公网地址/returnUrl";



    @RequestMapping("alipay")
    public void alipay(Integer orderId, HttpServletResponse httpResponse) throws IOException {
        //实例化客户端,填入所需参数
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        //在公共参数中设置回跳和通知地址
        request.setReturnUrl(RETURN_URL);
        request.setNotifyUrl(NOTIFY_URL);
        //根据订单编号,查询订单相关信息
        //Order order = payService.selectById(orderId);
        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = "1000010";//order.getOrderId().toString();
        //付款金额，必填
        String total_amount = "100029.99";//order.getOrderPrice().toString();
        //订单名称，必填
        String subject = "普通订单";//order.getOrderName();
        //商品描述，可空
        String body = "";
        request.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String form = "";
        try {
            form = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    @RequestMapping(value = "/returnUrl", method = RequestMethod.GET)
    public String returnUrl(HttpServletRequest request, HttpServletResponse response)
            throws IOException, AlipayApiException {
        System.out.println("=================================同步回调=====================================");

        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("utf-8"), "utf-8");
            params.put(name, valueStr);
        }

        System.out.println(params);//查看参数都有哪些
        boolean signVerified = AlipaySignature.rsaCheckV1(params, ALIPAY_PUBLIC_KEY, CHARSET, SIGN_TYPE); // 调用SDK验证签名
        //验证签名通过
        if(signVerified){
            // 商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            System.out.println("商户订单号="+out_trade_no);
            System.out.println("支付宝交易号="+trade_no);
            System.out.println("付款金额="+total_amount);

            //支付成功，修复支付状态
            //payService.updateById(Integer.valueOf(out_trade_no));
            return "ok";//跳转付款成功页面
        }else{
            return "no";//跳转付款失败页面
        }

    }

}