package com.result.my.shop.web.admin.web.controller;/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.web.admin.web.controller
 * @ClassName: TbContentController
 * @Author: 程伟钊
 * @Description:
 * @Date: 2019/4/21 16:29
 */

import com.result.my.shop.commons.dto.BaseResult;
import com.result.my.shop.commons.dto.PageInfo;
import com.result.my.shop.domain.TbContent;
import com.result.my.shop.web.admin.abstracts.abstractsBaseController;
import com.result.my.shop.web.admin.service.TbContentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @program: my-shop
 *
 * @description:
 *
 * @author: ReSult
 *
 * @create: 2019-04-21 16:29
 **/
@Controller
@RequestMapping(value = "content")
public class TbContentController extends abstractsBaseController<TbContent, TbContentService> {

    @ModelAttribute
    public TbContent getTbContent(Long id){
        TbContent tbContent = null;
        if (id != null){
            tbContent = service.selectById(id);
        }
        else {
            tbContent = new TbContent();
        }
        return tbContent;
    }

    /**
     * 跳转到内容列表页
     */
    @Override
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model) {
        List<TbContent> tbContents = service.selectAll();
        model.addAttribute("tbContents",tbContents);
        for (TbContent tbContent : tbContents) {
            System.out.println(tbContent);
        }
        return "content_list";
    }

    /**
     * 跳转到新增用户页
     */
    @Override
    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(){
        return "content_from";
    }

    /**
     * 分页
     * @param request
     * @return
     */
    @Override
    public PageInfo<TbContent> page(HttpServletRequest request) {
        return null;
    }


    /**
     * 保存信息
     */
    @Override
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(TbContent tbContent, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult = service.save(tbContent);
        //通过验证
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/content/list";
        }

        //不通过验证
        else{
            model.addAttribute("baseResult",baseResult);
            return "content_from";
        }
    }

    /**
     * 搜索操作
     */
    @Override
    @RequestMapping(value = "search",method = RequestMethod.POST)
    public String search(TbContent tbContent, Model model){
        List<TbContent> tbContents = service.search(tbContent);
        model.addAttribute("tbContents",tbContents);
        return "content_list";
    }


    /**
     * 删除信息：返回json数据：baseResult对象数据
     */
    @Override
    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public BaseResult delete(long id){
        BaseResult baseResult = service.delete(id);
        return baseResult;
    }

    /**
     * 查看详情：ajax访问
     */
    @Override
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail(TbContent tbContent){
        return "content_detail";
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Override
    public BaseResult deleteMulti(String ids) {
        return null;
    }

}
