package com.ls.springmvc.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ls.springmvc.mapper.ItemMapper;
import com.ls.springmvc.pojo.Item;
import com.ls.springmvc.pojo.QueryVo;
import com.ls.springmvc.service.ItemService;


@Service
public class ItemserviceImp implements ItemService {

	@Autowired
	private ItemMapper itemmapper;
	
	@Override
	public List<Item> getItemList() {
		// TODO Auto-generated method stub
		return itemmapper.selectByExample(null);
	}

	@Override
	public Item getItemById(Integer id) {
		
		
		
		return itemmapper.selectByPrimaryKey(id);
	}

	@Override
	public void upDateItem(Item item) {
		 itemmapper.updateByPrimaryKeySelective(item);	
	}

//	@Override
//	public Item queryItem(QueryVo queryVo) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
}
