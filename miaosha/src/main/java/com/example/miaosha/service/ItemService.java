package com.example.miaosha.service;

import java.util.List;

import com.example.miaosha.error.BusinessException;
import com.example.miaosha.model.ItemModel;

public interface ItemService {

	//创建商品
	ItemModel createItem(ItemModel itemModel) throws BusinessException;
	
	//商品列表浏览
	List<ItemModel> listItem();
	
	//商品详情浏览	
	ItemModel getItemById(Integer id);
}
