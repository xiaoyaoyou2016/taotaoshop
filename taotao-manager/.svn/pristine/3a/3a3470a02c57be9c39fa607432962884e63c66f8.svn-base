package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;

public interface ItemService {
	
	TbItem getItemById(long itemId);
	EUDataGridResult getItemList(int page,int rows);	
	TaotaoResult createItem(TbItem item, TbItemDesc itemDesc,String itemParam);
	TaotaoResult insertItemParamItem(Long itemId, String itemParam);
}
