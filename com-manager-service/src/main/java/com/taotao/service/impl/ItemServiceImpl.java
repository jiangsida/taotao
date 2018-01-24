package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemParam;
import com.taotao.service.ItemService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.EasyUIResult;
import pojo.IDUtils;
import pojo.TaotaoResult;

import java.util.Date;
import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {

    private  SqlSessionFactory sqlSessionFactory;
    @Autowired
    private TbItemMapper itemMapper;
    @Autowired
    private TbItemDescMapper itemDescMapper;
    @Autowired
    private TbItemParamMapper itemParamMapper;
    @Override
    public TbItem getItembyId (long itemId) {
        //TbItem item = itemMapper.selectByPrimaryKey(itemId);
        //添加查询条件
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(itemId);
        List<TbItem> list = itemMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            TbItem item = list.get(0);
            return item;
        }
        return null;
    }

    @Override
    public EasyUIResult getItemList (int page, int rows) {

        //查询商品列表
        TbItemExample example = new TbItemExample();
        //分页处理
        PageHelper.startPage(page, rows);
        List<TbItem> list = itemMapper.selectByExample(example);

        //取记录总条数
        //取分页信息
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        EasyUIResult result = new EasyUIResult(total, list);
        return result;
    }

    @Override
    public TaotaoResult createItem (TbItem item,String desc,String itemparam) {

        long id = IDUtils.genItemId ();
        item.setId (id);
         //1 正常 2下架 3刪除
         item.setStatus ((byte)1);
         item.setUpdated (new Date ());
         item.setCreated (new Date ());
         int i=itemMapper.insert (item);
         TaotaoResult result=insertDesc (id,desc);
            insertItemParamItem (id,itemparam);
            return TaotaoResult.ok ();

    }

    public  TaotaoResult insertItemParamItem(long itemId,String itemparam){

        TbItemParam tbItemParam = new TbItemParam ();
        tbItemParam.setId (itemId);
        tbItemParam.setParamData (itemparam);
        itemParamMapper.insert (tbItemParam);
            return  TaotaoResult.ok ();

    }

    public  TaotaoResult  insertDesc(long itemid, String desc){

//        TbItemDesc tbItemDesc = new TbItemDesc ();
//        tbItemDesc.setItemId (itemid);
//        tbItemDesc.setItemDesc (desc);
//
//        itemDescMapper.insert (tbItemDesc);
//        return  TaotaoResult.ok ();

        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setItemId(itemid);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());
        itemDescMapper.insert(itemDesc);
        return TaotaoResult.ok();

    }


}
