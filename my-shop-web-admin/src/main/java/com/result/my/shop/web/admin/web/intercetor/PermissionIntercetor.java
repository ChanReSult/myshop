package com.result.my.shop.web.admin.web.intercetor;/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.web.admin.web.intercetor
 * @ClassName: PermissionIntercetor
 * @Author: 程伟钊
 * @Description: 权限拦截器
 * @Date: 2019/4/17 18:20
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
 * @description: 权限拦截器
 *
 * @author: ReSult
 *
 * @create: 2019-04-17 18:20
 **/
public class PermissionIntercetor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //请求来自登录页
        if (modelAndView.getViewName().endsWith("login")) {
            TbUser tbUser = (TbUser) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);
            if (tbUser != null){
            // 则直接重定向到首页不再显示登录页
            httpServletResponse.sendRedirect("/main");
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
