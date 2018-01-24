package com.taotao.controller;

import com.taotao.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.EUTreeNode;

import java.util.List;

/**
 * @author jiang
 * @create 2018-01-07 19:36
 * @desc
 **/
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

    @Autowired
    public ContentCategoryService contentCategoryService;
   @RequestMapping("/list")
   @ResponseBody
    public List<EUTreeNode> getcategoryList(@RequestParam(value = "id" ,defaultValue = "0") long parentId ){
       return    contentCategoryService.getcategoryList (parentId);


    }
}
