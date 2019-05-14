package com.result.my.shop.web.admin.abstracts;/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.web.admin.abstracts
 * @ClassName: abstractsBaseController
 * @Author: 程伟钊
 * @Description: 控制器基类
 * @Date: 2019/4/29 20:43
 */

import com.result.my.shop.commons.dto.BaseResult;
import com.result.my.shop.commons.dto.PageInfo;
import com.result.my.shop.commons.persistence.BaseEntity;
import com.result.my.shop.commons.persistence.BaseService;
import com.result.my.shop.domain.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @program: my-shop
 *
 * @description: 控制器基类
 *
 * @author: ReSult
 *
 * @create: 2019-04-29 20:43
 **/
public abstract class abstractsBaseController<T extends BaseEntity,S extends BaseService<T>> {

    @Autowired
    protected S service;

    public abstract String list(Model model);

    /**
     * 保存信息
     * @param entity
     * @param model
     * @param redirectAttributes
     * @return
     */
    public abstract String save(T entity, Model model, RedirectAttributes redirectAttributes);

    /**
     * 删除
     * @param id
     * @return
     */
    public abstract BaseResult delete(long id);

    /**
     * 批量删除
     */
    public abstract BaseResult deleteMulti(String ids);

    /**
     * 查看详情
     */
    public abstract String detail(T t);

    /**
     * 搜索
     */
    public abstract String search(T t, Model model);

    /**
     * 跳转新增页
     * @return
     */
    public abstract String form();

    /**
     * 分页
     * @param request
     * @return
     */
    public abstract PageInfo<T> page(HttpServletRequest request);
}
