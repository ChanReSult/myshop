package com.result.my.shop.web.admin.service;

import com.result.my.shop.commons.dto.BaseResult;
import com.result.my.shop.commons.persistence.BaseService;
import com.result.my.shop.domain.TbUser;
import com.result.my.shop.web.admin.dao.TbUserDao;

import java.util.List;

/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.web.admin.service
 * @ClassName: TbUserService
 * @Author: 程伟钊
 * @Description: service层TbUser接口
 * @Date: 2019/4/16 22:35
 */
public interface TbUserService extends BaseService<TbUser> {

    /**
     * 登录：邮箱、密码
     */
    public TbUser login(String email,String password);

}
