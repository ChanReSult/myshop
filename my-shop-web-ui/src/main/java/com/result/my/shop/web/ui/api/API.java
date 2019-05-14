package com.result.my.shop.web.ui.api;/**
 * @ProjectName: myshop
 * @Package: com.result.my.shop.web.ui.api
 * @ClassName: API
 * @Author: 程伟钊
 * @Description: api常量
 * @Date: 2019/5/8 17:59
 */

/**
 * @program: myshop
 *
 * @description: api常量
 *
 * @author: ReSult
 *
 * @create: 2019-05-08 17:59
 **/
public class API {
    //主机地址
    public static final String HOST = "http://134.175.29.140:8080/api/v1";

    //内容查询接口
    public static final String API_content = HOST + "/contents/";

    //登录验证接口
    public static final String API_login = HOST + "/users/login";

    //注册接口
    public static final String API_register = HOST + "/users/register";


}
