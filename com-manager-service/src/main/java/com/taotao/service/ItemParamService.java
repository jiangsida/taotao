package com.taotao.service;

import com.taotao.pojo.TbItemParam;
import pojo.TaotaoResult;

/**
 * @author jiang
 * @create 2017-12-23 15:58
 * @desc
 **/
public interface ItemParamService {

    TaotaoResult  getItemParamByCid(long id);
    TaotaoResult insertItemParam(TbItemParam tbItemParam);

}
