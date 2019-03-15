package com.example.miaosha.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.miaosha.VOModel.ItemVO;
import com.example.miaosha.error.BusinessException;
import com.example.miaosha.model.ItemModel;
import com.example.miaosha.response.CommonReturnType;
import com.example.miaosha.service.ItemService;

@RestController
@RequestMapping("/item")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*" )

public class ItemController extends BaseController{

	@Autowired
	private ItemService itemService;
	
	@PostMapping("/create")
	public CommonReturnType createItem(@RequestBody(required = true) ItemModel itemModel) throws BusinessException{
		
		//调用service层完成创建
		ItemModel itemModelCreated = itemService.createItem(itemModel);		
		
		ItemVO itemVO = convertFromItemModel(itemModelCreated);
		return CommonReturnType.create(itemVO);
	}
	
    private ItemVO convertFromItemModel(ItemModel itemModel){
    	if (itemModel == null){
    		return null;
    	}
    	ItemVO itemVO = new ItemVO();
    	BeanUtils.copyProperties(itemModel, itemVO);
    	return itemVO;
    }
    
    @GetMapping("get")
    public CommonReturnType getItem(@RequestParam("id")Integer id){
    	ItemModel itemModel = itemService.getItemById(id);
    	ItemVO itemVO = convertFromItemModel(itemModel);    	
    	return CommonReturnType.create(itemVO);    	
    }
    
    @GetMapping("list")
    public CommonReturnType listItems(){
    	List<ItemModel> itemModelList = itemService.listItem();
    	List<ItemVO> ItemVOList = itemModelList.stream().map(itemModel -> {
    		ItemVO itemVO = convertFromItemModel(itemModel);
    		return itemVO;
    	}).collect(Collectors.toList());
    	return CommonReturnType.create(ItemVOList);
    }
    
    
    
    
    
    
    
    
    
}
