package com.result.my.shop.web.admin.service.impl;/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.web.admin.service.impl
 * @ClassName: TbUserServiceImpl
 * @Author: 程伟钊
 * @Description: TbUserService接口实现类
 * @Date: 2019/4/16 22:37
 */

import com.result.my.shop.domain.TbUser;
import com.result.my.shop.web.admin.abstracts.abstractsBaseServiceImpl;
import com.result.my.shop.web.admin.dao.TbUserDao;
import com.result.my.shop.web.admin.service.TbUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: my-shop
 *
 * @description: TbUserService接口实现类
 *
 * @author: ReSult
 *
 * @create: 2019-04-16 22:37
 **/
@Service
public class UserServiceImpl extends abstractsBaseServiceImpl<TbUser,TbUserDao> implements TbUserService{

    /**
    * 登录
    */ 
    @Override
    public TbUser login(String email, String password) {
        TbUser User = null;
        List<TbUser> tbUsers = Dao.selectAll();
        for (TbUser tbUser : tbUsers) {
            if (email.equals(tbUser.getEmail())){
                if (password.equals(tbUser.getPassword())){
                    return tbUser;
                }
            }
        }
        return null;
    }
}
