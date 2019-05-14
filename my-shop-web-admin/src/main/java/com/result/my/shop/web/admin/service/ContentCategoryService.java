package com.result.my.shop.web.admin.service;

import com.result.my.shop.commons.dto.BaseResult;
import com.result.my.shop.commons.persistence.BaseService;
import com.result.my.shop.domain.TbContentCategory;
import com.result.my.shop.domain.TbUser;

import java.util.List;

/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.web.admin.service
 * @ClassName: ContentCategoryService
 * @Author: 程伟钊
 * @Description:
 * @Date: 2019/4/20 19:54
 */
public interface ContentCategoryService extends BaseService<TbContentCategory> {

    /**
     * 根据父级节点，查询所有的子节点
     */
    public List<TbContentCategory> selectByPid(Long pId);

}
