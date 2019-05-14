package com.result.my.shop.web.ui.dto;/**
 * @ProjectName: myshop
 * @Package: com.result.my.shop.web.ui.dto
 * @ClassName: TbUser
 * @Author: 程伟钊
 * @Description: 用户数据传输对象
 * @Date: 2019/5/9 11:38
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @program: myshop
 *
 * @description: 用户数据传输对象
 *
 * @author: ReSult
 *
 * @create: 2019-05-09 11:38
 **/
@Data
public class TbUser implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String verification;
}
