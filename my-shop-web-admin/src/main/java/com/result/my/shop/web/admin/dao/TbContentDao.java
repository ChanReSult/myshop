package com.result.my.shop.web.admin.dao;

import com.result.my.shop.commons.persistence.BaseDao;
import com.result.my.shop.domain.TbContent;
import com.result.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.web.admin.dao
 * @ClassName: TbContentDao
 * @Author: 程伟钊
 * @Description:
 * @Date: 2019/4/21 16:27
 */
@Repository
public interface TbContentDao extends BaseDao<TbContent> {

    /**
     * 模糊查询：根据username、phone、email查询信息
     */
    public List<TbContent> search(TbContent tbContent);
}
