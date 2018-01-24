package com.taotao.service.impl;

import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.TaotaoResult;

import java.util.Date;
import java.util.List;

/**
 * @author jiang
 * @create 2017-12-23 15:59
 * @desc
 **/
@Service
public class ItemParamServiceImpl implements ItemParamService {

     @Autowired
     private TbItemParamMapper tbItemParamMapper;
    @Override
    public TaotaoResult getItemParamByCid (long id) {
        TbItemParamExample tbItemParamExample=new TbItemParamExample ();
        TbItemParamExample.Criteria criteria = tbItemParamExample.createCriteria ();
          criteria.andIdEqualTo (id);
        List<TbItemParam> list = tbItemParamMapper.selectByExampleWithBLOBs (tbItemParamExample);
        if (list!=null&&list.size ()>0){
            return  TaotaoResult.ok (list.get (0));
        }
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult insertItemParam (TbItemParam tbItemParam) {
        tbItemParam.setUpdated (new Date ());
        //tbItemParam.setParamData (new Date ());

        tbItemParamMapper.insert (tbItemParam);
        return TaotaoResult.ok ();
    }




}
