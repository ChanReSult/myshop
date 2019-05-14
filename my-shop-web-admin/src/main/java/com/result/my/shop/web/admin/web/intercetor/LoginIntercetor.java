package com.result.my.shop.web.admin.web.intercetor;/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.web.admin.web.intercetor
 * @ClassName: LoginIntercetor
 * @Author: 程伟钊
 * @Description: 登录拦截
 * @Date: 2019/4/17 10:26
 */

import com.result.my.shop.commons.constant.ConstantUtils;
import com.result.my.shop.domain.TbUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: my-shop
 *
 * @description: 登录拦截:拦截所有路径（除登录路径外），进行判断是否有登陆过。
 *
 * @author: ReSult
 *
 * @create: 2019-04-17 10:26
 **/
public class LoginIntercetor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        TbUser tbUser = (TbUser) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);
        //未登录
        if (tbUser == null){
            httpServletResponse.sendRedirect("/login");
        }
        //放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
