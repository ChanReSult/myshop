package com.result.my.shop.web.admin.abstracts;/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.web.admin.abstracts
 * @ClassName: abstractsBaseTreeController
 * @Author: 程伟钊
 * @Description: 树形结构控制器基类
 * @Date: 2019/4/29 21:25
 */

import com.result.my.shop.commons.dto.BaseResult;
import com.result.my.shop.commons.persistence.BaseEntity;
import com.result.my.shop.commons.persistence.BaseService;
import com.result.my.shop.domain.TbContentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @program: my-shop
 *
 * @description: 树形结构控制器基类
 *
 * @author: ReSult
 *
 * @create: 2019-04-29 21:25
 **/
public abstract class abstractsBaseTreeController<T extends BaseEntity ,S extends BaseService<T>> {

    @Autowired
    protected S service;

    /**
     * 保存信息
     * @param entity
     * @param model
     * @param redirectAttributes
     * @return
     */
    @Transactional(readOnly = false)
    public abstract String save(T entity, Model model, RedirectAttributes redirectAttributes);

    /**
     * 删除
     * @param id
     * @return
     */
    @Transactional(readOnly = false)
    public abstract BaseResult delete(long id);

    /**
     * 跳转新增页
     * @return
     */
    public abstract String form(TbContentCategory tbContentCategory);

}
