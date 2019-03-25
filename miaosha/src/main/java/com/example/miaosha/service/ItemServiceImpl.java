package com.example.miaosha.service;

import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.miaosha.dao.ItemMapper;
import com.example.miaosha.dao.ItemStockMapper;
import com.example.miaosha.entity.Item;
import com.example.miaosha.entity.ItemStock;
import com.example.miaosha.error.BusinessException;
import com.example.miaosha.error.EnBusinessError;
import com.example.miaosha.model.ItemModel;
import com.example.miaosha.model.PromoModel;
import com.example.miaosha.validate.ValidationResult;
import com.example.miaosha.validate.ValidatorImpl;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ValidatorImpl validator;
	
	@Autowired
	private ItemMapper itemMapper;
	
	@Autowired 
	private ItemStockMapper itemStockMapper;
	
	@Autowired
	private PromoService promoService;
	
	@Override
	@Transactional
	public ItemModel createItem(ItemModel itemModel) throws BusinessException {
		// TODO Auto-generated method stub
		//入参校验
		/*if (itemModel == null){
			throw new BusinessException(EnBusinessError.PARAMETER_VALIDATION_ERROR);
		}*/
		ValidationResult result = validator.validate(itemModel);
		if (result.isError()){
			throw new BusinessException(EnBusinessError.PARAMETER_VALIDATION_ERROR, result.getErrMsg());
		}
		//Model--->entity
		Item item = convertFromItemModel(itemModel);
		
		//写入数据库
		itemMapper.insertSelective(item);
		itemModel.setId(item.getId());
		
		ItemStock itemStock = convertFromItemStockModel(itemModel);
		itemStockMapper.insertSelective(itemStock);
		
		//返回结果
		return this.getItemById(itemModel.getId());
	}

	@Override
	public List<ItemModel> listItem() {
		// TODO Auto-generated method stub
		List<Item> itemList = itemMapper.listItem();
		List<ItemModel> itemModelList = itemList.stream().map(item -> {
			ItemStock itemStock = itemStockMapper.selectByItemId(item.getId());
			ItemModel itemModel = this.convertFromItemAndItemStock(item, itemStock);
			return itemModel;
		}).collect(Collectors.toList());
		return itemModelList;
	}

	@Override
	public ItemModel getItemById(Integer id) {
		// TODO Auto-generated method stub
		//从ItemMapper获取item实体entity
		Item item = itemMapper.selectByPrimaryKey(id);		
		if (item == null){
			return null;
		}
		//获取库存量
		ItemStock itemStock =  itemStockMapper.selectByItemId(item.getId());
		
		//Item entity & itemStock entity ----->ItemModel
		ItemModel itemModel = convertFromItemAndItemStock(item, itemStock);
		
		//获取商品秒杀活动
		PromoModel promoModel = promoService.getPromoByItemId(item.getId());
		if (promoModel != null && promoModel.getStatus() != 3){			
			itemModel.setPromoModel(promoModel);
		}		
		return itemModel;
	}
	
	private Item convertFromItemModel(ItemModel itemModel){
		if (itemModel == null ){
			return null;
		}
		Item item = new Item();
		BeanUtils.copyProperties(itemModel, item);
		return item;
	}
	
	private ItemStock convertFromItemStockModel(ItemModel itemModel){
		if (itemModel == null ){
			return null;
		}
		ItemStock itemStock = new ItemStock();
		itemStock.setStock(itemModel.getStock());
		itemStock.setItemId(itemModel.getId());
		return itemStock;
		
	}
	private ItemModel convertFromItemAndItemStock(Item item, ItemStock itemStock){
		if (item == null){
			return null;
		}
		ItemModel itemModel = new ItemModel();
		BeanUtils.copyProperties(item, itemModel);
		if (itemStock != null){
			itemModel.setStock(itemStock.getStock());
		}
		return itemModel;
	}

	@Override
	public Boolean decreseStock(Integer itemId, Integer amount) {
		// TODO Auto-generated method stub
		int affectRows = itemStockMapper.decreaseStock(itemId, amount);
		if (affectRows <= 0){
			//更新库存失败
			return false;
		}else{
			//更新库存成功
			return true;			
		}
	}

	@Override
	@Transactional
	public void increaseSales(Integer itemId, Integer amount) {
		// TODO Auto-generated method stub
		itemMapper.increaseSales(itemId, amount);		
	}
		
		
}
