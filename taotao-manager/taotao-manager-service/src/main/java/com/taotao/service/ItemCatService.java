package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemCat;

public interface ItemCatService {

	TbItemCat getItemCatById(long itemCatId);
	List<EUTreeNode> getItemCatList(long parentId);
}
