package com.taotao.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.utils.ExceptionUtil;
import com.taotao.common.utils.IDUtils;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.service.ItemService;

/**
 * 商品管理Service
 * @author zhoulinbin
 *
 */

@Service 
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	@Autowired
	private TbItemDescMapper itemDescMapper;
	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;
	
	@Override
	public TbItem getItemById(long itemId) {
		// TODO Auto-generated method stub
		
		//TbItem item = itemMapper.selectByPrimaryKey(itemId);
		
		TbItemExample example =new TbItemExample();
		//添加查询条件
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			TbItem item=list.get(0);
			return item;
			
		}
		return null;
	}
	
	/**
	 * 商品列表查询
	 */
	@Override
	public EUDataGridResult getItemList(int page, int rows) {
		// TODO Auto-generated method stub
		
		//查询商品列表
		TbItemExample example=new TbItemExample();
		
		//分页获取数据
		PageHelper.startPage(page, rows);
		List<TbItem> list = itemMapper.selectByExample(example);
		
		//返回值对象
		EUDataGridResult result=new EUDataGridResult();
		result.setRows(list);
		
		//取记录总数
//		PageInfo pageInfo=new PageInfo(list);
		PageInfo<TbItem> pageInfo=new PageInfo<TbItem>(list);
		long total = pageInfo.getTotal();
		result.setTotal(total);
		
		return result;
	}

	@Override
	public TaotaoResult createItem(TbItem item, TbItemDesc itemDesc,String itemParam) {
		// TODO Auto-generated method stub
		try {
			//生成商品id
			//可以使用redis的自增长key，在没有redis之前使用时间+随机数策略生成
			Long itemId = IDUtils.genItemId();
			//补全不完整的字段
			item.setId(itemId);
			item.setStatus((byte) 1);
			Date date = new Date();
			item.setCreated(date);
			item.setUpdated(date);
			//把数据插入到商品表
			itemMapper.insert(item);
			//添加商品描述
			itemDesc.setItemId(itemId);
			itemDesc.setCreated(date);
			itemDesc.setUpdated(date);
			//把数据插入到商品描述表
			itemDescMapper.insert(itemDesc);
			
//			//添加规格参数
//			TbItemParamItem itemParamItem = new TbItemParamItem();
//			itemParamItem.setItemId(itemId);
//			itemParamItem.setParamData(itemParam);
//			itemParamItem.setC reated(new Date());
//			itemParamItem.setUpdated(new Date());
//			//向表中插入数据
//			itemParamItemMapper.insert(itemParamItem);
			
			TaotaoResult result =insertItemParamItem(itemId, itemParam);
			if(result.getStatus()!=200)
			{
				throw new Exception();
			}
			return TaotaoResult.ok();
			
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

	/**
	 * 添加商品规格参数
	 */
	@Override
	public TaotaoResult insertItemParamItem(Long itemId, String itemParam) {
		//创建一个pojo
		TbItemParamItem itemParamItem = new TbItemParamItem();
		itemParamItem.setItemId(itemId);
		itemParamItem.setParamData(itemParam);
		itemParamItem.setCreated(new Date());
		itemParamItem.setUpdated(new Date());
		//向表中插入数据
		itemParamItemMapper.insert(itemParamItem);
		
		return TaotaoResult.ok();
	}

}
