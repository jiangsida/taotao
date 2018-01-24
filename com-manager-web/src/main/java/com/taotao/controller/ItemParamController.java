package com.taotao.controller;

import com.taotao.pojo.TbItemParam;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.TaotaoResult;

/**
 * @author jiang
 * @create 2017-12-23 16:10
 * @desc
 **/
@Controller
@RequestMapping("/item/param")
public class ItemParamController {
    //    ItemParamService  itemParamService=new ItemParamServiceImpl();
    @Autowired
    private ItemParamService  itemParamService;
    @RequestMapping("/query/itemcatid/{itemCatId}")
    @ResponseBody
    public TaotaoResult getItemParamByCid(@PathVariable long itemCatId){

        TaotaoResult result= itemParamService.getItemParamByCid (itemCatId);

        return result;
    }
    @RequestMapping("/save/{cid}")
    @ResponseBody
    public  TaotaoResult insertItemParam(@PathVariable long cid,String paramData,String itemParam){
        TbItemParam tbItemParam = new TbItemParam ();
        tbItemParam.setId (cid);
        tbItemParam.setParamData (paramData);
        TaotaoResult result = itemParamService.insertItemParam (tbItemParam);
        return   result;
    }
}
