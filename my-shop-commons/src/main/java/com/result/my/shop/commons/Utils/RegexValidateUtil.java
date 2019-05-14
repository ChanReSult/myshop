package com.result.my.shop.commons.Utils;/**

 * @ProjectName: my-shop
 * @Package: com.result.my.shop.commons.Utils
 * @ClassName: RegexValidateUtil
 * @Author: 程伟钊
 * @Description: 正则表达式验证
 * @Date: 2019/4/18 16:05
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: my-shop
 *
 * @description: 正则表达式验证
 *
 * @author: ReSult
 *
 * @create: 2019-04-18 16:05
 **/
public class RegexValidateUtil {
    static boolean flag = false;
    static String regex = "";
    public static final String PHONE = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
    public static final String EMAIL = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    public static boolean check(String str, String regex) {
        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(str);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 验证邮箱
     *
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        String regex = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        return check(email, regex);
    }
    /**
     * 验证手机号码
     *
     * 移动号码段:139、138、137、136、135、134、150、151、152、157、158、159、182、183、187、188、147
     * 联通号码段:130、131、132、136、185、186、145
     * 电信号码段:133、153、180、189
     *
     * @param cellphone
     * @return
     */
    public static boolean checkCellphone(String cellphone) {
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
        return check(cellphone, regex);
    }
}

