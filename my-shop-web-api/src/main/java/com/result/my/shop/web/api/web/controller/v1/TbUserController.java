package com.result.my.shop.web.api.web.controller.v1;/**
 * @ProjectName: myshop
 * @Package: com.result.my.shop.web.api.web.controller.v1
 * @ClassName: TbUserController
 * @Author: 程伟钊
 * @Description:
 * @Date: 2019/5/8 22:20
 */

import com.result.my.shop.commons.Utils.MapperUtil;
import com.result.my.shop.commons.dto.BaseResult;
import com.result.my.shop.domain.TbUser;
import com.result.my.shop.web.api.service.TbUserService;
import com.result.my.shop.web.api.web.dto.TbUserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会员管理
 * @program: myshop
 *
 * @description:
 *
 * @author: ReSult
 *
 * @create: 2019-05-08 22:20
 **/
@RestController
@RequestMapping(value = "${api.path.v1}/users")
public class TbUserController {
    @Autowired
    private TbUserService tbUserService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public BaseResult login(TbUser tbUser){
        BaseResult baseResult = null;
        TbUserDTO tbUserDTO = new TbUserDTO();

        TbUser user = tbUserService.login(tbUser);

        if(user == null){
            baseResult = BaseResult.fail("账号或密码不存在");
        }
        else {
            BeanUtils.copyProperties(user, tbUserDTO);
            baseResult = BaseResult.success("成功",tbUserDTO);
        }
        return baseResult;
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public BaseResult register(TbUser tbUser){
        BaseResult baseResult = null;
        Boolean register = tbUserService.register(tbUser);

        //注册成功
        if (register){
            baseResult = BaseResult.success("成功");
        }

        //注册失败
        else {
            baseResult = BaseResult.fail("失败");
        }
        return baseResult;

    }
}
