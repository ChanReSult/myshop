package com.result.my.shop.web.api.service.impl;/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.web.api.service.impl
 * @ClassName: TbcontentServiceImpl
 * @Author: 程伟钊
 * @Description:
 * @Date: 2019/5/7 11:42
 */

import com.result.my.shop.domain.TbContent;
import com.result.my.shop.domain.TbContentCategory;
import com.result.my.shop.web.api.dao.TbContentDao;
import com.result.my.shop.web.api.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: my-shop
 *
 * @description:
 *
 * @author: ReSult
 *
 * @create: 2019-05-07 11:42
 **/
@Service
@Transactional(readOnly = true)
public class TbContentServiceImpl implements TbContentService {

    @Autowired
    private TbContentDao tbContentDao;

    @Override
    public List<TbContent> selectByCategoryId(Long catagoryId) {
        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setId(catagoryId);

        TbContent tbContent = new TbContent();
        tbContent.setTbContentCategory(tbContentCategory);
        return tbContentDao.selectByCategoryId(tbContent);
    }
}
