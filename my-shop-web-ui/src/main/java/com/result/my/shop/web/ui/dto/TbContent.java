package com.result.my.shop.web.ui.dto;/**
 * @ProjectName: myshop
 * @Package: com.result.my.shop.web.ui.dto
 * @ClassName: Tbcontroller
 * @Author: 程伟钊
 * @Description:
 * @Date: 2019/5/8 17:22
 */

import lombok.Data;

/**
 * @program: myshop
 *
 * @description:
 *
 * @author: ReSult
 *
 * @create: 2019-05-08 17:22
 **/
@Data
public class TbContent {
    private Long id;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
}
