package com.result.my.shop.web.api.service.impl;/**
 * @ProjectName: myshop
 * @Package: com.result.my.shop.web.api.service.impl
 * @ClassName: TbUserServiceImpl
 * @Author: 程伟钊
 * @Description:
 * @Date: 2019/5/8 22:12
 */

import com.result.my.shop.domain.TbUser;
import com.result.my.shop.web.api.dao.TbUserDao;
import com.result.my.shop.web.api.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @program: myshop
 *
 * @description:
 *
 * @author: ReSult
 *
 * @create: 2019-05-08 22:12
 **/
@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDao tbUserDao;
    @Override
    public TbUser login(TbUser tbUser) {
        TbUser user = tbUserDao.login(tbUser);
        if (user != null){
            String password = tbUser.getPassword();
            if (password.equals(user.getPassword())){
                return user;
            }
        }
        return null;
    }

    @Override
    public Boolean register(TbUser tbUser) {
        TbUser user = tbUserDao.seletctByUsername(tbUser);
        String username = user.getUsername();

        //用户已经存在
        if(StringUtils.equals(username,tbUser.getUsername())){
            return false;
        }
        //用户不存在，可以添加
        else {
            tbUser.setUpdated(new Date());
            tbUser.setCreated(new Date());
            tbUserDao.register(tbUser);
            return true;
        }
    }
}
