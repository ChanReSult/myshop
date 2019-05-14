package com.result.my.shop.web.admin.service.impl;/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.web.admin.service.impl
 * @ClassName: ContentCatogeryServiceImpl
 * @Author: 程伟钊
 * @Description:
 * @Date: 2019/4/20 19:55
 */

import com.result.my.shop.commons.dto.BaseResult;
import com.result.my.shop.commons.validator.BeanValidator;
import com.result.my.shop.domain.TbContentCategory;
import com.result.my.shop.web.admin.abstracts.abstractsBaseServiceImpl;
import com.result.my.shop.web.admin.dao.ContentCategoryDao;
import com.result.my.shop.web.admin.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @program: my-shop
 *
 * @description:
 *
 * @author: ReSult
 *
 * @create: 2019-04-20 19:55
 **/

@Service
public class ContentCategoryServiceImpl extends abstractsBaseServiceImpl<TbContentCategory,ContentCategoryDao> implements ContentCategoryService {

    @Override
    public List<TbContentCategory> selectByPid(Long pId) {
        return Dao.selectByPid(pId);
    }

    /**
     * 保存
     * @param entity
     * @return
     */
    @Override
    @Transactional(readOnly = false)
    public BaseResult save(TbContentCategory entity) {
        String validator = BeanValidator.validator(entity);
        //验证不通过
        if (validator != null) {
            return BaseResult.fail(validator);
        }
        //通过验证
        else {
            TbContentCategory parent = entity.getParentTbContentCategory();
            //如果没有选择父级节点，则为根目录
            if (parent == null || parent.getId() == null){
                parent.setId(0l);
            }
            entity.setUpdated(new Date());

            //id为空，新增
            if (entity.getId() == null) {
                entity.setCreated(new Date());
                entity.setIsParent(false);

                //判断当前新增的节点，存在父级节点
                if (parent.getId() != 0l){
                    TbContentCategory currentCategoryParent = selectById(parent.getId());
                    //判断当前新增的节点的父级节点，是否存在
                    if (currentCategoryParent != null){
                        currentCategoryParent.setIsParent(true);
                        update(currentCategoryParent);
                    }
                }
                //根目录
                else {
                    //根目录，则为父级节点
                    entity.setIsParent(true);
                }

                insert(entity);

            }

            //id存在，修改
            else {
                update(entity);
            }
            return BaseResult.success("保存用户信息成功");
        }
    }
}

