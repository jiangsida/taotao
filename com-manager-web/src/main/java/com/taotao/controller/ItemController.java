package com.taotao.controller;

import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.EasyUIResult;
import pojo.TaotaoResult;

/**
 * @author jiang
 * @create 2017-12-01 15:47
 * @desc
 **/
@Controller

public class ItemController {

    @Autowired
    public ItemService itemService;


    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById( @PathVariable long itemId){
        TbItem tbItem=itemService.getItembyId (itemId);
         return  tbItem;
     }
     @RequestMapping(value = "/item/save",method = RequestMethod.POST)
     @ResponseBody
     public TaotaoResult createItem(TbItem item,String desc, String itemParams){

         TaotaoResult taotaoResult = itemService.createItem (item,desc,itemParams);
         return  taotaoResult;
     }

    //设置相应的内容为json数据
    @RequestMapping("/item/list")//("/list")
    @ResponseBody
    public ResponseEntity<EasyUIResult> getItemlist(@RequestParam(defaultValue="1")Integer page,

                                                    @RequestParam(defaultValue="30")Integer rows) throws Exception {

        try{
            //查询商品列表
          EasyUIResult result = itemService.getItemList(page, rows);

           return  ResponseEntity.ok (result);
        }catch ( Exception e){
             ResponseEntity.status (HttpStatus.INTERNAL_SERVER_ERROR).body (null);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body (null);
    }

}
