package com.result.my.shop.web.api.dao;/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.web.api.dao
 * @ClassName: TbcontentDao
 * @Author: 程伟钊
 * @Description:
 * @Date: 2019/5/7 11:37
 */

import com.result.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: my-shop
 *
 * @description:
 *
 * @author: ReSult
 *
 * @create: 2019-05-07 11:37
 **/
@Repository
public interface TbContentDao {

    /**
     * 根据类别ID查询内容列表
     */
    List<TbContent> selectByCategoryId(TbContent tbContent);
}
