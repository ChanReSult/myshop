package com.result.my.shop.web.ui.controller;/**
 * @ProjectName: myshop
 * @Package: com.result.my.shop.web.ui.controller
 * @ClassName: RegisterController
 * @Author: 程伟钊
 * @Description: 注册控制器
 * @Date: 2019/5/10 16:13
 */

import com.result.my.shop.commons.Utils.HttpclientUtill;
import com.result.my.shop.web.ui.dto.TbUser;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

import static com.result.my.shop.web.ui.api.API.API_register;

/**
 * @program: myshop
 *
 * @description: 注册控制器
 *
 * @author: ReSult
 *
 * @create: 2019-05-10 16:13
 **/
@Controller
public class RegisterController {

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String register(TbUser tbUser){

        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username",tbUser.getUsername()));
        params.add(new BasicNameValuePair("password",tbUser.getPassword()));
        params.add(new BasicNameValuePair("phone",tbUser.getPhone()));
        String json = HttpclientUtill.doPost(API_register, params.toArray(new BasicNameValuePair[params.size()]));
        System.out.println(json);
        return null;
    }

}
