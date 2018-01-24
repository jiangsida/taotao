package com.taotao.service;

import pojo.EUTreeNode;

import java.util.List;

/**
 * @author jiang
 * @create 2017-12-12 15:49
 * @desc
 **/
public interface ItemCatService {
    List<EUTreeNode> queryItemCatList (long parentid);
}
