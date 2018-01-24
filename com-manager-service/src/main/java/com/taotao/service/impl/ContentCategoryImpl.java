package com.taotao.service.impl;

import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.EUTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiang
 * @create 2018-01-07 19:16
 * @desc
 **/
@Service
public class ContentCategoryImpl implements ContentCategoryService {

     @Autowired
     public TbContentCategoryMapper  tbContentCategoryMapper;
    @Override
    public List<EUTreeNode> getcategoryList (Long parentId) {

        TbContentCategoryExample categoryExample = new TbContentCategoryExample ();
        TbContentCategoryExample.Criteria criteria = categoryExample.createCriteria ();
                 criteria.andParentIdEqualTo (parentId);
        List<TbContentCategory> list = tbContentCategoryMapper.selectByExample (categoryExample);
        ArrayList<EUTreeNode> euTreeNodes = new ArrayList<> ();
        for (TbContentCategory tb  :list) {
            EUTreeNode node = new EUTreeNode ();
                 node.setId (tb.getParentId ());
                 node.setText (tb.getName ());
                 node.setState (tb.getIsParent ()?"closed":"open");
            euTreeNodes.add (node);
        }
        return euTreeNodes;
    }
}
