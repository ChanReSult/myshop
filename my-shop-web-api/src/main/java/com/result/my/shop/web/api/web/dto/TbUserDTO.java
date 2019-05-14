package com.result.my.shop.web.api.web.dto;/**
 * @ProjectName: myshop
 * @Package: com.result.my.shop.web.api.web.dto
 * @ClassName: TbUserDTO
 * @Author: 程伟钊
 * @Description: 用户数据传输对象
 * @Date: 2019/5/9 11:28
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.result.my.shop.commons.Utils.RegexValidateUtil;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * @program: myshop
 *
 * @description: 用户数据传输对象
 *
 * @author: ReSult
 *
 * @create: 2019-05-09 11:28
 **/
@Data
public class TbUserDTO {
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private String phone;
    private String email;
}
