package com.result.my.shop.web.admin.web.controller;/**
 * @ProjectName: my-shop
 * @Package: com.result.my.shop.web.admin.web.controller
 * @ClassName: UploadController
 * @Author: 程伟钊
 * @Description: 文件上传控制器
 * @Date: 2019/4/27 19:57
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @program: my-shop
 *
 * @description: 文件上传控制器
 *
 * @author: ReSult
 *
 * @create: 2019-04-27 19:57
 **/
@Controller
public class UploadController {

    private static final String UPLOAD_PATH = "/assets/upload/";
    /**
     * dropFile: dropzone
     * editorFile: wangEditor
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public Map<String,Object> upload(MultipartFile dropFile,MultipartFile editorFile, HttpServletRequest request){
        MultipartFile myFile =  dropFile == null ? editorFile : dropFile;
        Map<String,Object> result = new HashMap<>();
        //文件名
        String filename = myFile.getOriginalFilename();
        //文件名后缀
        String fileSuffix = filename.substring(filename.lastIndexOf("."));
        //文件存放路径
        String filePath = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);
        //判断路径是否存在，不存在则创建文件夹
        File file = new File(filePath);
        if (!file.exists()){
            file.mkdir();
        }
        file = new File(filePath, UUID.randomUUID()+fileSuffix);
        try {
            myFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String serverPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        //dropzone上传
        if (dropFile != null){
            result.put("fileName",serverPath + UPLOAD_PATH + file.getName());
        }
        //wangEditor上传
        else {
            /**
             * request.getScheme():服务段提供的协议
             * request.getServerName() :服务段提供的域名
             * request.getServerPort():服务段提供的端口
             */
            result.put("errno",0);
            result.put("data",new String[] {serverPath + UPLOAD_PATH + file.getName()});

        }
        return result;
    }
}
