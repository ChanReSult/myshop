package com.result.my.shop.domain;/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.domain
 * @ClassName: TbUser
 * @Author: 程伟钊
 * @Description: TbUser实体类
 * @Date: 2019/4/16 22:25
 */

import com.result.my.shop.commons.persistence.BaseEntity;
import com.result.my.shop.commons.Utils.RegexValidateUtil;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @program: my-shop
 *
 * @description: TbUser实体类
 *
 * @author: ReSult
 *
 * @create: 2019-04-16 22:25
 **/
@Data
public class TbUser extends BaseEntity implements Serializable {
    @Length(min = 6, max = 20, message = "姓名的长度必须介于6-20位之间！")
    private String username;

    @NotBlank(message = "密码不能为空！")
    private String password;

    @Pattern(regexp = RegexValidateUtil.PHONE, message = "手机格式不正确")
    private String phone;

    @Pattern(regexp = RegexValidateUtil.EMAIL, message = "邮箱格式不正确")
    private String email;

}
