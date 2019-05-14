package com.result.my.shop.web.ui.controller;/**
 * @ProjectName: myshop
 * @Package: com.result.my.shop.web.ui.controller
 * @ClassName: LoginController
 * @Author: 程伟钊
 * @Description: 登录控制器
 * @Date: 2019/5/9 11:36
 */

import com.google.code.kaptcha.Constants;
import com.result.my.shop.commons.Utils.HttpclientUtill;
import com.result.my.shop.commons.Utils.MapperUtil;
import com.result.my.shop.commons.dto.BaseResult;
import com.result.my.shop.web.ui.api.UsersApi;
import com.result.my.shop.web.ui.dto.TbUser;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

import static com.result.my.shop.web.ui.api.API.API_login;

/**
 * @program: myshop
 *
 * @description: 登录控制器
 *
 * @author: ReSult
 *
 * @create: 2019-05-09 11:36
 **/
@Controller
public class LoginController {

    /**
     * 跳转登录页
     * @return
     */
    @RequestMapping(value = "loginPage",method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    /**
     * 跳转注销页
     * @return
     */
    @RequestMapping(value = "registerPage",method = RequestMethod.GET)
    public String registerPage(){
        return "zhuc";
    }

    /**
     * 登录
     * @param tbUser
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(TbUser tbUser, Model model, HttpServletRequest request){
        //验证码验证失败
        if (!checkVerification(tbUser, request)){
            model.addAttribute("baseResult", BaseResult.fail("验证码验证错误，请重新输入！"));
            return "login";
        }
        TbUser user = UsersApi.login(tbUser);
        //登录成功
        if (user != null){
            request.getSession().setAttribute("tbUser",user);
            return "redirect:index";
        }
        //登录失败
        else {
            model.addAttribute("baseResult", BaseResult.fail("会户名或密码错误，请重新输入！"));
            return "login";
        }
    }

    /**
     * 注销
     * @return
     */
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:index";
    }

    /**
     * 检查验证码
     * @param tbUser
     * @param request
     * @return
     */
    public Boolean checkVerification(TbUser tbUser,HttpServletRequest request){
        String verification = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (StringUtils.equals(tbUser.getVerification(),verification)){
            return true;
        }
        return false;
    }
}
