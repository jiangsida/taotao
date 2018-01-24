package com.taotao.rest.service.impl;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.rest.pojo.CatNode;
import com.taotao.rest.pojo.CatResult;
import com.taotao.rest.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiang
 * @create 2018-01-05 10:45
 * @desc
 **/
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;
    @Override
    public CatResult getItemCatList () {

        CatResult catResult = new CatResult ();
        catResult.setData (getCatList(0));
        return null;
    }

    private List<?> getCatList (long parentId) {

        TbItemCatExample example = new TbItemCatExample ();
        TbItemCatExample.Criteria criteria = example.createCriteria ();

        criteria.andParentIdEqualTo (parentId);
        List<TbItemCat> list = tbItemCatMapper.selectByExample (example);

        List list1 = new ArrayList ();

        for(TbItemCat tbItemCat :list){
            if (tbItemCat.getIsParent ()) {
                CatNode catNode = new CatNode ();
                if (parentId == 0) {
                    catNode.setName ("<a href='/products/" + tbItemCat.getId () + ".html'>" + tbItemCat.getName () + "</a>");
                } else {

                    catNode.setName (tbItemCat.getName ());
                }
                catNode.setUrl ("/products/" + tbItemCat.getId () + ".html");
                catNode.setItem (getCatList (tbItemCat.getId ()));
                list1.add (catNode);
            } else{

                 list1.add ("/products/" + tbItemCat.getId () + ".html|"+tbItemCat.getName ());
            }
        }
        return  list;
    }
}
