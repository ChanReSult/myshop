package com.result.my.shop.commons.dto;/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.commons.dto
 * @ClassName: BaseResult
 * @Author: 程伟钊
 * @Description: 结果集
 * @Date: 2019/4/18 9:31
 */

import java.io.Serializable;

/**
 * @program: my-shop
 *
 * @description: 结果集
 *
 * @author: ReSult
 *
 * @create: 2019-04-18 09:31
 **/
public class BaseResult implements Serializable {

    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAIL = 500;


    public int status;
    public String message;

    //add
    public Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    //

    public static BaseResult success(){

        return BaseResult.createResult(STATUS_SUCCESS,"成功",null);
    }

    public static BaseResult success(String message){

        return BaseResult.createResult(STATUS_SUCCESS,message,null);
    }

    public static BaseResult success(String message,Object data){

        return BaseResult.createResult(STATUS_SUCCESS,message,data);
    }

    public static BaseResult fail(){
        return BaseResult.createResult(STATUS_FAIL,"失败",null);
    }

    public static BaseResult fail(String message){
        return BaseResult.createResult(STATUS_FAIL,message,null);
    }

    public static BaseResult fail(String message,Object data){
        return BaseResult.createResult(STATUS_FAIL,message,data);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private static BaseResult createResult(int status,String message,Object data){
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        baseResult.setData(data);
        return baseResult;
    }
}
