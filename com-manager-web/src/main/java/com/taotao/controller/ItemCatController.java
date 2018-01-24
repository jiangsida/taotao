package com.taotao.controller;

import com.taotao.service.ItemCatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.EUTreeNode;

import java.util.List;

/**
 * @author jiang
 * @create 2017-12-12 15:42
 * @desc 商品类目
 **/
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
    private ItemCatService itemCatService;

    @RequestMapping(value ="list")
    @ResponseBody
    public List<EUTreeNode> queryItemCatList(@RequestParam(value ="id",defaultValue ="0") long parentid){


        return   itemCatService.queryItemCatList (parentid);

    }
}
