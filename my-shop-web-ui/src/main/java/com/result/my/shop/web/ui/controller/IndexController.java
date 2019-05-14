package com.result.my.shop.web.ui.controller;/**
 * @ProjectName: myshop
 * @Package: com.result.my.shop.web.ui.controller
 * @ClassName: IndexController
 * @Author: 程伟钊
 * @Description:
 * @Date: 2019/5/8 1:35
 */

import com.result.my.shop.web.ui.api.ContentsApi;
import com.result.my.shop.web.ui.dto.TbContent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @program: myshop
 *
 * @description:
 *
 * @author: ReSult
 *
 * @create: 2019-05-08 01:35
 **/
@Controller
public class IndexController {

    @RequestMapping(value = {"","index"},method = RequestMethod.GET)
    public String index(Model model){
        List<TbContent> tbContents = ContentsApi.ppt();
        for (TbContent tbcontent : tbContents) {
            System.out.println(tbcontent);
        }
        model.addAttribute("ppt",tbContents);
        return "index";
    }
}
