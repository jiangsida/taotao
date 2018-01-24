package com.taotao.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * @author jiang
 * @create 2017-12-20 14:23
 * @desc
 **/
public interface IpictureService {


    Map uploadPicture(MultipartFile uploadFile) throws IOException;
}
