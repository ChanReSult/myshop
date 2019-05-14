package com.result.my.shop.web.admin.web.controller;/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.web.admin.web.controller
 * @ClassName: TbContentCatogeryController
 * @Author: 程伟钊
 * @Description:
 * @Date: 2019/4/20 19:55
 */

import com.result.my.shop.commons.dto.BaseResult;
import com.result.my.shop.domain.TbContentCategory;
import com.result.my.shop.web.admin.abstracts.abstractsBaseTreeController;
import com.result.my.shop.web.admin.service.ContentCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: my-shop
 *
 * @description: ContentCategory控制器
 *
 * @author: ReSult
 *
 * @create: 2019-04-20 19:55
 **/
@Controller
@RequestMapping(value = "content/category")
public class ContentCategoryController extends abstractsBaseTreeController<TbContentCategory, ContentCategoryService> {

   @ModelAttribute
    public TbContentCategory getTbContent(Long id){
        TbContentCategory tbContentCategory = null;
        if (id != null){
            tbContentCategory = service.selectById(id);
        }
        else {
            tbContentCategory = new TbContentCategory();
        }
        return tbContentCategory;
    }

    /**
     * 跳转到新增分类页
     */
    @Override
    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(TbContentCategory tbContentCategory){
        return "content_catogery_from";
    }

    /**
    * 保存：修改/新增
    */
    @Override
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(TbContentCategory tbContentCategory, Model model,RedirectAttributes redirectAttributes){
        BaseResult baseResult = service.save(tbContentCategory);
        //保存成功
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/content/category/list";
        }
        //保存失败
        else {
            model.addAttribute("baseResult",baseResult);
            return form(tbContentCategory);
        }
    }

    @Override
    public BaseResult delete(long id) {
        return null;
    }

    /**
    * 跳转到分类列表页
    */
    @RequestMapping(value = "list")
    public String list(Model model){
        List<TbContentCategory> targetList = new ArrayList<TbContentCategory>();
        List<TbContentCategory> tbContentCategories = service.selectAll();
        sortList(tbContentCategories,targetList,0L);
        model.addAttribute("tbContentCategories",targetList);
        return "content_catogery_list";
    }

    /** 
    * 树形结构
    */ 
    @ResponseBody
    @RequestMapping(value = "tree/data",method = RequestMethod.POST)
    public List<TbContentCategory> treeData(Long id){
        if (id == null){
            id = 0l;
        }
        return service.selectByPid(id);
    }

    /**
     * 排序
    * [sourceList：数据源集合, targetList：排序后集合, parentId：父节点的id]
    */
    private void sortList(List<TbContentCategory> sourceList, List<TbContentCategory> targetList, Long Id){
        for (TbContentCategory tbContentCategory : sourceList) {
            //判断tbContentCategory.parentId是否等于Id（根节点为0）,等于的话（tbContentCategory为根节点），将tbContentCategory添加到List中
            if (tbContentCategory.getParentTbContentCategory().getId().equals(Id)){
                targetList.add(tbContentCategory);

                //判断有没有子节点，有的话，List继续追加
                if (tbContentCategory.getIsParent()){
                    for (TbContentCategory contentCategory : sourceList) {

                        //判断contentCategory.ParentId是否等于tbContentCategory.Id,等于的话（contentCategory属于tbContentCategory下的节点），
                        // 将ContentCategory添加到List中
                        if (contentCategory.getParentTbContentCategory().getId().equals(tbContentCategory.getId())){
                            //递归
                            sortList(sourceList,targetList,tbContentCategory.getId());
                            break;
                        }
                    }
                }
            }
        }
    }

}
