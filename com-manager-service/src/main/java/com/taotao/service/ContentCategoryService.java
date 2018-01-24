package com.taotao.service;

import pojo.EUTreeNode;

import java.util.List;

/**
 * @author jiang
 * @create 2018-01-07 19:14
 * @desc
 **/
public interface ContentCategoryService {

    public List<EUTreeNode> getcategoryList(Long parentId);
}
