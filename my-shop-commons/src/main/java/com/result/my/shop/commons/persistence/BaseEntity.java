package com.result.my.shop.commons.persistence;/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.commons.persistence
 * @ClassName: BaseEntity
 * @Author: 程伟钊
 * @Description: 实体类-基类
 * @Date: 2019/4/20 16:59
 */

import java.io.Serializable;
import java.util.Date;

/**
 * @program: my-shop
 *
 * @description: 实体类-基类
 *
 * @author: ReSult
 *
 * @create: 2019-04-20 16:59
 **/
public abstract class BaseEntity implements Serializable {
    private Long id;
    private Date created;
    private Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
