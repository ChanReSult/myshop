package com.result.my.shop.commons.Utils;/**
 * @ProjectName: hello-httpclient
 * @Package: com.result.hello.httpclient
 * @ClassName: HttpclientUtill
 * @Author: 程伟钊
 * @Description: Httpclient工具类
 * @Date: 2019/5/5 23:32
 */

import org.apache.http.HttpEntity;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;

/**
 *
 *
 * @description: Httpclient工具类
 *
 * @author: ReSult
 *
 * @create: 2019-05-05 23:32
 **/
public class HttpclientUtill {
    private static String REQUEST_METHOD_GET = "GET";
    private static String REQUEST_METHOD_POST = "POST";
    private static String REQUEST_HEADER_CONNECTION = "keep-alive";
    private static String REQUEST_HEADER_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36";

    //get请求，带cookie
    public static String doGet(String url,String cookie){
        return createRequest("GET", url, cookie);
    }

    //get请求，不带cookie
    public static String doGet(String url){
        return createRequest("GET", url, null);
    }

    //post请求，带cookie
    public static String doPost(String url,String cookie,BasicNameValuePair... params){
        return createRequest("POST", url, cookie, params);
    }

    //post请求，不带cookie
    public static String doPost(String url,BasicNameValuePair... params){
        return createRequest("POST", url, null, params);
    }

    /**\
     *
     * @param method 请求方式
     * @param url   请求链接
     * @param cookie
     * @param params 请求参数
     * @return
     */
    private static String createRequest(String method,String url,String cookie,BasicNameValuePair... params){
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        HttpGet httpGet = null;
        HttpPost httpPost = null;
        HttpEntity entity = null;
        String result = null;

        try {
            //创建HTTPclient客户端
            httpClient = HttpClients.createDefault();

            //get请求
            if (method.equals(REQUEST_METHOD_GET)){
                //创建GET请求
                httpGet = new HttpGet(url);

                //设置长链接
                httpGet.setHeader("Connection",REQUEST_HEADER_CONNECTION);
                //设置代理（模拟浏览器版本）
                httpGet.setHeader("User-Agent",REQUEST_HEADER_USER_AGENT);
                //设置cookie
                httpGet.setHeader("Cookie",cookie);

                //发送请求,得到响应
                httpResponse = httpClient.execute(httpGet);
                //获取响应数据
                entity = httpResponse.getEntity();
            }

            //Post请求
            else if (method.equals(REQUEST_METHOD_POST)){
                //创建post请求
                httpPost = new HttpPost(url);

                //设置长链接
                httpPost.setHeader("Connection",REQUEST_HEADER_CONNECTION);
                //设置代理（模拟浏览器版本）
                httpPost.setHeader("User-Agent",REQUEST_HEADER_USER_AGENT);
                //设置cookie
                httpPost.setHeader("Cookie",cookie);

                if (params != null && params.length > 0){
                    //键值对被UrlEncodedFormEntity实例编码后,变为?key1=value1&key2=value2
                    httpPost.setEntity(new UrlEncodedFormEntity(Arrays.asList(params), "UTF-8"));
                }

                //客户端发送请求,得到响应
                 httpResponse = httpClient.execute(httpPost);
                //获取响应数据
                entity = httpResponse.getEntity();
            }

            //将响应数据转成字符串
            result = EntityUtils.toString(entity);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (httpClient != null){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
