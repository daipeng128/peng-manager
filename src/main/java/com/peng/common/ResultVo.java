package com.peng.common;

/**
 * @Auther: daipeng
 * @Date: 2018/10/31 19:43
 * @Description:
 */
public class ResultVo<T> {

    private Integer code;

    private Boolean success;

    private T data;

    //成功返回
    public static <T> ResultVo<T> success(T data){
        ResultVo<T> resultVo = new ResultVo<T>();
        resultVo.setData(data);
        resultVo.setCode(200);
        resultVo.setSuccess(true);
        return resultVo;
    }


    //成功但code需要单独指定
    public static <T> ResultVo<T> success(Integer code,T data){
        ResultVo<T> resultVo = new ResultVo<T>();
        resultVo.setData(data);
        resultVo.setCode(code);
        resultVo.setSuccess(true);
        return resultVo;
    }

    //调用失败
    public static <T> ResultVo<T> error(Integer code,T data){
        ResultVo<T> resultVo = new ResultVo<T>();
        resultVo.setData(data);
        resultVo.setCode(code);
        resultVo.setSuccess(false);
        return resultVo;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
