package com.result.my.shop.commons.persistence;

import com.result.my.shop.commons.dto.BaseResult;
import com.result.my.shop.commons.dto.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.commons.persistence
 * @ClassName: BaseService
 * @Author: 程伟钊
 * @Description: 所有业务逻辑层的基类
 * @Date: 2019/4/29 13:32
 */

public interface BaseService<T extends BaseEntity> {

    /**
     * 保存
     */
    public BaseResult save(T entity);

    /**
     * 查询所有
     */
    public List<T> selectAll();

    /**
     * 模糊查询
     */
    public List<T> search(T entity);

    /**
     * 查询L根据id
     */
    public T selectById(Long id);

    /**
     * 删除
     */
    public BaseResult delete(Long id);

    /**
     * 批量删除
     */
    public void deleteMulti(String[] ids);

    /**
     * 添加
     */
    public void insert(T entity);

    /**
     * 修改
     */
    public void update(T entity);

    /**
     * 总笔数
     */
    public int count();

    /**
     * 分页查询
     */
    public PageInfo<T> page(int start, int length,int draw);


}
