package com.result.my.shop.domain;/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.domain
 * @ClassName: TbContent
 * @Author: 程伟钊
 * @Description: 内容实体类
 * @Date: 2019/4/21 16:15
 */

import com.result.my.shop.commons.persistence.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @program: my-shop
 *
 * @description: 内容实体类
 *
 * @author: ReSult
 *
 * @create: 2019-04-21 16:15
 **/
@Data
public class TbContent extends BaseEntity {


    @Length(min = 1,max = 20, message = "标题长度介意1-20字符之间")
    private String title;

    @Length(min = 1,max = 20, message = "子标题长度介意1-20字符之间")
    private String subTitle;

    @Length(min = 1,max = 50, message = "标题描述长度介意1-20字符之间")
    private String titleDesc;

    private String url;

    private String pic;

    private String pic2;

    @Length(min = 1, message = "内容不能为空")
    private String content;

    @NotNull(message = "父级类目不能为空,请重新输入")
    private TbContentCategory tbContentCategory;
}
