package com.result.my.shop.web.admin.dao;

import com.result.my.shop.commons.persistence.BaseDao;
import com.result.my.shop.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.web.admin.dao
 * @ClassName: TbContentCatogeryDao
 * @Author: 程伟钊
 * @Description: 分类
 * @Date: 2019/4/20 19:54
 */
@Repository
public interface ContentCategoryDao extends BaseDao<TbContentCategory> {
    public List<TbContentCategory> selectByPid(Long pId);
}
