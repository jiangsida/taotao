package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jiang
 * @create 2017-12-01 17:41
 * @desc 通用的页面跳转
 **/
@Controller
public class PageController {
   //返回的是string怎没有responseBody，如果没有返回实际的数据类型
    @RequestMapping("/")
    public String showIndex(){

        return "index";
    }

    /**
     *
     * @param page 展示其他页面
     * @return
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){

        return  page;
    }
}
