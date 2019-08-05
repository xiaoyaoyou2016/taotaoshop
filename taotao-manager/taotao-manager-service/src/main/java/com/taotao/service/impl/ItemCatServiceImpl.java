package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	@Override
	public List<EUTreeNode> getItemCatList(long parentId) {
		// TODO Auto-generated method stub
		
		TbItemCatExample example=new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		//分类列表转换成TreeNode的列表
		List<EUTreeNode> resultList = new ArrayList<EUTreeNode>();
		for (TbItemCat tbItemCat : list) {
			//创建一个TreeNode对象
			EUTreeNode node = new EUTreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			node.setState(tbItemCat.getIsParent()? "closed" : "open");
			//(tbItemCat.getId(), tbItemCat.getName(), tbItemCat.getIsParent()?"closed":"open");
			resultList.add(node);
		}
		return resultList;
	}

	@Override
	public TbItemCat getItemCatById(long itemCatId) {
		TbItemCat item = itemCatMapper.selectByPrimaryKey(itemCatId);
		
		return item;
	}

}
