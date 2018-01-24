package com.taotao.controller;

import com.taotao.service.IpictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * @author jiang
 * @create 2017-12-20 15:10
 * @desc
 **/
@Controller
public class PictureController {



    @Autowired
    public IpictureService ipictureService;
    //@RequestMapping("/pic/upload")
    @RequestMapping("/pic/upload")
    @ResponseBody
    public Map pictureUpload (MultipartFile uploadFile) throws IOException {

        Map   result=ipictureService.uploadPicture(uploadFile);
       //String     json=JsonUtils.objectToJson(result);
    return  result;
  }
}
