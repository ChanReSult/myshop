package com.result.my.shop.web.api.web.dto;/**
 * @ProjectName: myshop
 * @Package: com.result.my.shop.web.api.web.dto
 * @ClassName: TbcontentDTO
 * @Author: 程伟钊
 * @Description:
 * @Date: 2019/5/7 18:03
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @program: myshop
 *
 * @description:内容数据传输对象
 *
 * @author: ReSult
 *
 * @create: 2019-05-07 18:03
 **/
@Data
public class TbcontentDTO implements Serializable {
    private Long id;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;

}
