package com.taotao.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jiang
 * @create 2018-01-04 9:04
 * @desc
 **/
@Controller
public class IndexController {

    @RequestMapping("/index")
    public  String showindex(){
        return "index";
    }
}
