package com.result.my.shop.web.admin.service;/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.web.admin.service
 * @ClassName: test
 * @Author: 程伟钊
 * @Description: test类
 * @Date: 2019/4/16 22:49
 */

import com.result.my.shop.commons.dto.BaseResult;
import com.result.my.shop.commons.Utils.RegexValidateUtil;
import com.result.my.shop.domain.TbContent;
import com.result.my.shop.domain.TbContentCategory;
import com.result.my.shop.domain.TbUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * @program: my-shop
 *
 * @description: test类
 *
 * @author: ReSult
 *
 * @create: 2019-04-16 22:49
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context-mybatis.xml", "classpath:spring-context-druid.xml", "classpath:spring-context.xml"})
public class test {

    @Autowired
    private TbUserService tbUserService;
    @Autowired
    private ContentCategoryService contentCategoryService;
    @Autowired
    private TbContentService tbContentService;

    @Test
    public void TbUserServerImplLogintest() {
        TbUser tbUser = tbUserService.login("123@qq.com", "123");
        System.out.println(tbUser.toString());
    }

    @Test
    public void tbUserServiceSaveTest() {
        TbUser tbUser = tbUserService.selectById(38L);
        tbUser.setUsername("cwz");
        tbUser.setPassword("123456");
        tbUserService.save(tbUser);
    }

    @Test
    public void regexValidateUtilTest(){
        boolean b = RegexValidateUtil.checkEmail("122236525@qq.com");
        System.out.println(b);

    }


    @Test
    public void seletctByIdTest() {
        TbUser tbUser = tbUserService.selectById(18L);
        System.out.println(tbUser.getPassword());
    }


    @Test
    public void contentCategoryServiceSeletctAllTest(){
        List<TbContentCategory> tbContentCategories = contentCategoryService.selectAll();
        for (TbContentCategory tbContentCategory : tbContentCategories) {
            System.out.println(tbContentCategory.getName());
        }
    }


    /*//TbContentCategory排序测试
    @Test
    public void contentCategorySortTest(){
        List<TbContentCategory> targetList = new ArrayList<>();
        List<TbContentCategory> sourceList = contentCategoryService.selectAll();
        sortList(sourceList,targetList,0L);
        for (TbContentCategory tbcc : targetList) {
            System.out.println(tbcc.getName());
        }

    }

    public void sortList(List<TbContentCategory> sourceList, List<TbContentCategory> targetList, Long Id){
        for (TbContentCategory tbContentCategory : sourceList) {
            //判断tbContentCategory.parentId是否等于Id（根节点为0）,等于的话（tbContentCategory为根节点），将tbContentCategory添加到List中
            if (tbContentCategory.getParentId().equals(Id)){
                targetList.add(tbContentCategory);
                //判断有没有子节点，有的话，List继续追加
                if (tbContentCategory.getIsParent()){
                    for (TbContentCategory contentCategory : sourceList) {
                        //判断contentCategory.ParentId是否等于tbContentCategory.Id,等于的话（contentCategory属于tbContentCategory下的节点），将ContentCategory添加到List中
                        if (contentCategory.getParentId().equals(tbContentCategory.getId())){
                            //递归
                            sortList(sourceList,targetList,tbContentCategory.getId());
                            break;
                        }
                    }
                }
            }
        }
    }*/


    //tbContentServiceSave测试
    @Test
    public void tbContentServiceSaveTest(){
        TbContent tbContent = new TbContent();
        tbContent.setTitleDesc("asdf");
        tbContent.setTitle("asdf");
        tbContent.setContent("sfasdasd");
        tbContent.setUpdated(new Date());
        tbContent.setCreated(new Date());
        BaseResult baseResult = tbContentService.save(tbContent);
        System.out.println(baseResult.getStatus());
    }

    //abstractsBaseServiceImpl的count测试
    @Test
    public void abstractsBaseServiceImplCount(){
        System.out.println("asasdfasdfffffffffffff");
        int count = tbUserService.count();
        System.out.println("111111111111111111111111111111");
        System.out.println(count);
    }

    }
