package com.result.my.shop.web.ui.api;/**
 * @ProjectName: myshop
 * @Package: com.result.my.shop.web.ui.api
 * @ClassName: UsersApi
 * @Author: 程伟钊
 * @Description:
 * @Date: 2019/5/9 11:46
 */

import com.result.my.shop.commons.Utils.HttpclientUtill;
import com.result.my.shop.commons.Utils.MapperUtil;
import com.result.my.shop.commons.dto.BaseResult;
import com.result.my.shop.web.ui.dto.TbUser;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

import static com.result.my.shop.web.ui.api.API.API_login;
import static com.result.my.shop.web.ui.contants.SysContants.TREE_NODE;

/**
 * @program: myshop
 *
 * @description: 用户接口
 *
 * @author: ReSult
 *
 * @create: 2019-05-09 11:46
 **/
public class UsersApi {

    public static TbUser login(TbUser tbUser){
        TbUser user = null;

        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username",tbUser.getUsername()));
        params.add(new BasicNameValuePair("password",tbUser.getPassword()));
        String json = HttpclientUtill.doPost(API_login, params.toArray(new BasicNameValuePair[params.size()]));

        try {
            user = MapperUtil.json2pojoByTreeNode(json.toString(), TREE_NODE, TbUser.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
