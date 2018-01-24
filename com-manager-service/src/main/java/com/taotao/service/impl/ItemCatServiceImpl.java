package com.taotao.service.impl;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.EUTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiang
 * @create 2017-12-12 16:17
 * @desc
 **/
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;
    @Override
    public List<EUTreeNode> queryItemCatList (long parentid) {

                //  TbItemCat =new TbItemCat ();
        TbItemCatExample example=new TbItemCatExample();
        TbItemCatExample.Criteria criteria=example.createCriteria ();
                    criteria.andParentIdEqualTo (parentid);
        List<TbItemCat> list=tbItemCatMapper.selectByExample (example);
        List<EUTreeNode> treeNodesList=new ArrayList<> ();
        for (TbItemCat item : list){
            EUTreeNode treeNode=new EUTreeNode ();
            treeNode.setId (item.getId ());
            treeNode.setState (item.getIsParent ()?"closed":"open");
            treeNode.setText (item.getName ());
            treeNodesList.add (treeNode);
         }
       return  treeNodesList;
    }
}
