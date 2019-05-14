package com.result.my.shop.web.api.service;

import com.result.my.shop.domain.TbContent;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.web.api.service
 * @ClassName: TbcontentService
 * @Author: 程伟钊
 * @Description:
 * @Date: 2019/5/7 11:40
 */
@Service
public interface TbContentService {
    /**
     * 根据类别ID查询内容列表
     */
    List<TbContent> selectByCategoryId(Long catagoryId);
}
