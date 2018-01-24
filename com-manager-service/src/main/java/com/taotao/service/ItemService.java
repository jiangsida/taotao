package com.taotao.service;


import com.taotao.pojo.TbItem;
import pojo.EasyUIResult;
import pojo.TaotaoResult;

public interface ItemService {


    public TbItem getItembyId(long itemid);

    EasyUIResult getItemList(int page, int rows);

     TaotaoResult createItem(TbItem item,String desc,String itemParam);

}
