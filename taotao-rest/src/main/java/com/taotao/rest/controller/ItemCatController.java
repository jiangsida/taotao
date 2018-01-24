package com.taotao.rest.controller;

import com.taotao.rest.pojo.CatResult;
import com.taotao.rest.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jiang
 * @create 2018-01-05 16:10
 * @desc
 **/
public class ItemCatController {
     @Autowired
    private ItemCatService  itemCatService;

//   @RequestMapping("/itemcat/list")
//   @ResponseBody
//    public String getItemCatList(String callback){
//
//       CatResult catResult=itemCatService.getItemCatList ();
//
//            String json=JsonUtils.objectToJson (catResult);
//
//            String result=callback+"("+json+")";
//            return  result;
//   }

    @RequestMapping("/itemcat/list")
    @ResponseBody
    public Object getItemCatList(String callback){
        CatResult catResult=itemCatService.getItemCatList ();

        MappingJacksonValue jacksonValue = new MappingJacksonValue (catResult);
         jacksonValue.setJsonpFunction (callback);
          return  jacksonValue;
    }
}
