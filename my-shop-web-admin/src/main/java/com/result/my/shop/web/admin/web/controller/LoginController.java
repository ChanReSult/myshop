package com.result.my.shop.web.admin.web.controller;/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.web.admin.web.controller
 * @ClassName: TbUserController
 * @Author: 程伟钊
 * @Description: TbUser控制器类
 * @Date: 2019/4/17 15:07
 */

import com.result.my.shop.commons.constant.ConstantUtils;
import com.result.my.shop.domain.TbUser;
import com.result.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: my-shop
 *
 * @description: 登录控制器
 *
 * @author: ReSult
 *
 * @create: 2019-04-17 15:07
 **/
@Controller
public class LoginController {
    @Autowired
    private TbUserService tbUserService ;

    @RequestMapping(value = {"","login"}, method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "main")
    public String main(){
        return "main";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String email, @RequestParam(required = true) String password, Model model, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        TbUser tbUser = tbUserService.login(email, password);
        if (tbUser != null){
            System.out.println("登陆成功"+tbUser);
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER,tbUser);
            return "redirect:main";
        }else{
            model.addAttribute("message","用户名或密码错误，请重新输入");
            return login();
        }
    }

    @RequestMapping(value = "logout")
    public String logout(){
        return "login";
    }
}
