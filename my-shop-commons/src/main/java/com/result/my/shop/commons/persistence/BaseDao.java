package com.result.my.shop.commons.persistence;/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.commons.persistence
 * @ClassName: BaseDao
 * @Author: 程伟钊
 * @Description:
 * @Date: 2019/4/28 11:35
 */

import com.result.my.shop.commons.dto.PageInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @program: my-shop
 *
 * @description:所有数据访问层的基类
 *
 * @author: ReSult
 *
 * @create: 2019-04-28 11:35
 **/
@Repository
public interface BaseDao<T extends BaseEntity> {

    /**
     * 添加
     */
    public void insert(T entity);

    /**
     * 删除
     */
    public void delete(Long id);

    /**
     * 批量删除
     */
    public void deleteMulti(String[] ids);

    /**
     * 修改
     */
    public void update(T entity);

    /**
     * 查询：通过id
     */
    public T selectById(Long id);

    /**
     * 查询所有
     */
    public List<T> selectAll();

    /**
     * 模糊查询
     */
    public List<T> search(T entity);

    /**
     * 分页查询
     */
    public List<T> page(Map<String,Object> param);
}
