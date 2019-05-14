package com.result.my.shop.web.admin.abstracts;/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.web.admin.abstracts
 * @ClassName: abstractsBaseServiceImpl
 * @Author: 程伟钊
 * @Description: 业务逻辑层实现基类
 * @Date: 2019/4/29 16:20
 */

import com.result.my.shop.commons.dto.BaseResult;
import com.result.my.shop.commons.dto.PageInfo;
import com.result.my.shop.commons.persistence.BaseDao;
import com.result.my.shop.commons.persistence.BaseEntity;
import com.result.my.shop.commons.persistence.BaseService;
import com.result.my.shop.commons.validator.BeanValidator;
import com.result.my.shop.domain.TbContentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: my-shop
 *
 * @description: 业务逻辑层实现基类
 *
 * @author: ReSult
 *
 * @create: 2019-04-29 16:20
 **/
@Service
public abstract class abstractsBaseServiceImpl<T extends BaseEntity,D extends BaseDao<T>> implements BaseService<T> {

    @Autowired
    protected D Dao;

    /**
     * 查询：通过ID
     * @param id
     * @return
     */
    @Override
    public T selectById(Long id) {
        return Dao.selectById(id);
    }

    /**
     * 查询全部
     * @return
     */
    @Override
    public List<T> selectAll() {
        return Dao.selectAll();
    }

    /**
     * 搜索
     * @param entity
     * @return
     */

    @Override
    public List<T> search(T entity) {
        return null;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    @Transactional(readOnly = false)
    public BaseResult delete(Long id) {
        BaseResult baseResult = BaseResult.success();
        Dao.delete(id);
        T t = selectById(id);
        if (t == null){
            baseResult.setMessage("已删除用户信息！");
        }
        else {
            baseResult = BaseResult.fail();
            baseResult.setMessage("删除用户信息失败！");
        }
        return baseResult;
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    @Transactional(readOnly = false)
    public void deleteMulti(String[] ids) {
        Dao.deleteMulti(ids);
    }

    /**
     * 添加
     */
    @Override
    @Transactional(readOnly = false)
    public void insert(T entity) {
        Dao.insert(entity);
    }

    /**
     * 保存
     * @param entity
     * @return
     */
    @Override
    @Transactional(readOnly = false)
    public BaseResult save(T entity) {
        String validator = BeanValidator.validator(entity);
        //验证不通过
        if (validator != null) {
            return BaseResult.fail(validator);
        }
        //通过验证
        else {
            entity.setUpdated(new Date());

            //id为空，插入
            if (entity.getId() == null) {
                entity.setCreated(new Date());
                insert(entity);
            }

            //id存在，修改
            else {
                update(entity);
            }
            return BaseResult.success("保存用户信息成功");
        }
    }

    /**
     * 修改
     * @param entity
     */
    @Override
    @Transactional(readOnly = false)
    public void update(T entity) {
        Dao.update(entity);
    }

    @Override
    public int count() {
        List<T> ts = Dao.selectAll();
        System.out.println(ts.size());
        return ts.size();
    }

    @Override
    public PageInfo<T> page(int start, int length,int draw) {
        Map<String,Object> param = new HashMap<>();
        param.put("start",start);
        param.put("length",length);
        List<T> list = Dao.page(param);

        PageInfo<T> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsFiltered(count());
        pageInfo.setRecordsTotal(count());
        pageInfo.setData(list);

        return pageInfo;
    }

}
