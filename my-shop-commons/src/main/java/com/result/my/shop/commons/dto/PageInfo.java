package com.result.my.shop.commons.dto;/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.commons.dto
 * @ClassName: PageInfo
 * @Author: 程伟钊
 * @Description: 分页传输数据
 * @Date: 2019/5/2 20:54
 */

import com.result.my.shop.commons.persistence.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: my-shop
 *
 * @description: 分页传输数据
 *
 * @author: ReSult
 *
 * @create: 2019-05-02 20:54
 **/
@Data
public class PageInfo<T extends BaseEntity> implements Serializable {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private List<T> data;
    private String error;

}
