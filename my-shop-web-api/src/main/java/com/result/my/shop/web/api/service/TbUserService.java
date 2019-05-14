package com.result.my.shop.web.api.service;

import com.result.my.shop.domain.TbUser;

/**
 * @ProjectName: myshop
 * @Package: com.result.my.shop.web.api.service
 * @ClassName: TbUserService
 * @Author: 程伟钊
 * @Description:
 * @Date: 2019/5/8 22:12
 */
public interface TbUserService {

    /**
     * 登录
     * @param tbuser
     * @return
     */
    TbUser login(TbUser tbuser);

    /**
     * 注册
     * @param tbUser
     * @return
     */
    Boolean register(TbUser tbUser);
}
