package com.taotao.service.impl;

import com.taotao.service.IpictureService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pojo.FtpUtil;
import pojo.IDUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jiang
 * @create 2017-12-20 14:27
 * @desc
 **/
@Service
public class PictureServiceImpl implements IpictureService {


    //使用spring el表达式

    @Value ("${FTP_ADDRESS}")
    private String FTP_ADDRESS;
    @Value ("${FTP_USENAME}")
    private  String FTP_USENAME;
    @Value ("${FTP_PASSWORD}")
    private  String FTP_PASSWORD;
    @Value ("${FTP_BASE_PATH}")
    private  String FTP_BASE_PATH;
    @Value ("${IMAGE_BASE_URL}")
    private  String IMAGE_BASE_URL;

    @Override
    public Map uploadPicture (MultipartFile uploadFile)  {
        Map reultMap = new HashMap ();
        //生成一个文件名称
        String oldName = uploadFile.getOriginalFilename ();
        String newName = IDUtils.genImageName ();
        newName = newName + oldName.substring (oldName.lastIndexOf ("."));
        String image_path= new DateTime ().toString ("/yyyy/MM/dd");
        //图片上传
        try {
            boolean result = FtpUtil.uploadFile (FTP_ADDRESS, 21, FTP_USENAME, FTP_PASSWORD, FTP_BASE_PATH, image_path , newName, uploadFile.getInputStream ());

            if (!result) {
                reultMap.put ("error", 1);
                reultMap.put ("message", "上传失败");

                return reultMap;
            }

                reultMap.put ("error", 0);
                reultMap.put ("url",IMAGE_BASE_URL+image_path+"/"+newName);
              return reultMap;
            } catch (IOException e) {
                e.printStackTrace ();
            }

                reultMap.put ("error", 1);
                reultMap.put ("message", "上传失败");

                return reultMap;
    }
}
