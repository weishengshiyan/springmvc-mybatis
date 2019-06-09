package com.ls.springmvc.service;

import java.util.List;

import com.ls.springmvc.pojo.Item;
import com.ls.springmvc.pojo.QueryVo;

public interface ItemService {
	
	List<Item> getItemList();
	Item getItemById(Integer id);
	void upDateItem(Item item);
//	Item queryItem(QueryVo queryVo);
	

}
