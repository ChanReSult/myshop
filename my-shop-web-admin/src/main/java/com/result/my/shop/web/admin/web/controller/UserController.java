package com.result.my.shop.web.admin.web.controller;/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.web.admin.web.controller
 * @ClassName: UserController
 * @Author: 程伟钊
 * @Description: 用户控制器
 * @Date: 2019/4/17 22:13
 */

import com.result.my.shop.commons.dto.BaseResult;
import com.result.my.shop.commons.dto.PageInfo;
import com.result.my.shop.domain.TbUser;
import com.result.my.shop.web.admin.abstracts.abstractsBaseController;
import com.result.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: my-shop
 *
 * @description: 用户控制器
 *
 * @author: ReSult
 *
 * @create: 2019-04-17 22:13
 **/
@Controller
@RequestMapping(value = "user")
public class UserController extends abstractsBaseController<TbUser,TbUserService> {

    @ModelAttribute
    public TbUser getTbUser(Long id){
        TbUser tbUser = null;
        if (id != null){
            tbUser = service.selectById(id);
        }
        else {
            tbUser = new TbUser();
        }
        return tbUser;
    }

    @Override
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model){
        List<TbUser> tbUsers = service.selectAll();
        model.addAttribute("tbUsers",tbUsers);
        return "user_list";
    }

    /** 
    * 跳转新增页
    */
    @Override
    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(){
        return "user_from";
    }

    /**
     * 保存信息
     */
    @Override
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(TbUser tbUser, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = service.save(tbUser);
        //通过验证
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/user/list";
        }

        //不通过验证
        else{
            model.addAttribute("baseResult",baseResult);
            return "user_from";
        }
    }

    /** 
    * 搜索操作，根据姓名，手机号，邮箱搜索
    */
    @Override
    @RequestMapping(value = "search",method = RequestMethod.POST)
    public String search(TbUser tbUser, Model model){
        List<TbUser> tbUsers = service.search(tbUser);
        model.addAttribute("tbUsers",tbUsers);
        return "user_list";
    }

    /**
    * 删除操作，赶回json数据：baseResult对象数据
    */ 
    @Override
    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public BaseResult delete(long id) {
        BaseResult baseResult = service.delete(id);
        return baseResult;
    }

    /**
     * 批量删除操作，赶回json数据：baseResult对象数据
     */
    @Override
    @ResponseBody
    @RequestMapping(value = "deleteMulti",method = RequestMethod.POST)
    public BaseResult deleteMulti(String ids){
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)){
            String[] idArray = ids.split(",");
            service.deleteMulti(idArray);
            baseResult = BaseResult.success("删除数据成功");
        }
        else {
            baseResult = BaseResult.fail("删除数据失败");
        }
        return baseResult;
    }

    /** 
    * 查看详情，ajax访问，返回user_detail页面
    */
    @Override
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail(TbUser tbUser){
        return "user_detail";
    }

    /**
     * 分页查询
     * @param request
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public PageInfo<TbUser> page(HttpServletRequest request){

        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 :Integer.parseInt(strDraw);
        int start = strStart == null ? 0 :Integer.parseInt(strStart);
        int length = strLength == null ? 10 :Integer.parseInt(strLength);

        //封装datatables需要的结果
        PageInfo<TbUser> pageInfo = service.page(start, length, draw);

        return pageInfo;
    }
}
