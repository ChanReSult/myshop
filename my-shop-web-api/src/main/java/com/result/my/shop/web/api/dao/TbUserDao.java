package com.result.my.shop.web.api.dao;

import com.result.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

/**
 * 会员管理
 * @ProjectName: myshop
 * @Package: com.result.my.shop.web.api.dao
 * @ClassName: Tbuser
 * @Author: 程伟钊
 * @Description:
 * @Date: 2019/5/8 22:10
 */
@Repository
public interface TbUserDao {

    /**
     * 登录
     * @param tbuser
     * @return
     */
    TbUser login(TbUser tbuser);

    /**
     * 注册
     * @param tbUser
     */
    void register(TbUser tbUser);

    /**
     * 查询：根据用户名
     * @param tbUser
     * @return
     */
    TbUser seletctByUsername(TbUser tbUser);
}
