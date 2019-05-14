package com.result.my.shop.domain;/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.domain
 * @ClassName: TbContentCategory
 * @Author: 程伟钊
 * @Description:
 * @Date: 2019/4/20 16:45
 */

import com.result.my.shop.commons.persistence.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @program: my-shop
 *
 * @description:
 *
 * @author: ReSult
 *
 * @create: 2019-04-20 16:45
 **/

@Data
public class TbContentCategory extends BaseEntity {
       @Length(min = 1,max = 20, message = "名字长度介意1-20字符之间")
       private String name;
       private Integer status;
       @NotNull(message = "排序不能为空")
       private Integer sortOrder;
       private Boolean isParent;
       private TbContentCategory parentTbContentCategory;

}
