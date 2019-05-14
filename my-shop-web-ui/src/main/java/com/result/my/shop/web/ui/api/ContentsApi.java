package com.result.my.shop.web.ui.api;/**
 * @ProjectName: myshop
 * @Package: com.result.my.shop.web.ui.api
 * @ClassName: contentsAPI
 * @Author: 程伟钊
 * @Description: 内容接口
 * @Date: 2019/5/8 18:06
 */

import com.result.my.shop.commons.Utils.HttpclientUtill;
import com.result.my.shop.commons.Utils.MapperUtil;
import com.result.my.shop.web.ui.dto.TbContent;

import java.util.List;

import static com.result.my.shop.web.ui.api.API.API_content;
import static com.result.my.shop.web.ui.contants.SysContants.PPT_categoryID;
import static com.result.my.shop.web.ui.contants.SysContants.TREE_NODE;

/**
 * @program: myshop
 *
 * @description: 内容接口
 *
 * @author: ReSult
 *
 * @create: 2019-05-08 18:06
 **/
public class ContentsApi {

    public static List<TbContent> ppt(){
        List<TbContent> tbContents = null;

        //请求返回json数据
        String json = HttpclientUtill.doGet( API_content + PPT_categoryID);

        try {
            tbContents = MapperUtil.json2listByTreeNode(json.toString(), TREE_NODE, TbContent.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tbContents;
    }
}
