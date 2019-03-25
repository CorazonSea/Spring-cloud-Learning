package com.example.miaosha.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.miaosha.VOModel.UserVO;
import com.example.miaosha.dao.OrderInfoMapper;
import com.example.miaosha.dao.SequenceMapper;
import com.example.miaosha.entity.OrderInfo;
import com.example.miaosha.entity.Sequence;
import com.example.miaosha.error.BusinessException;
import com.example.miaosha.error.EnBusinessError;
import com.example.miaosha.model.ItemModel;
import com.example.miaosha.model.OrderModel;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ItemService itemService;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private SequenceMapper sequenceMapper;
	
	@Autowired
	private OrderInfoMapper orderInfoMapper;
	
	@Override
	@Transactional	
	public OrderModel createOrder(Integer userId, Integer itemId, Integer promoId, Integer amount) throws BusinessException {
		// TODO Auto-generated method stub
		//入参校验,用户是否合法，商品是否存在，购买数量是否合法
		ItemModel itemModel = itemService.getItemById(itemId);
		UserVO user = userService.getUserById(userId);
		if (itemModel == null){
			throw new BusinessException(EnBusinessError.ITEM_NOT_EXIST);
		}
		if (user == null){
			throw new BusinessException(EnBusinessError.USER_NOT_EXIST);
		}
		if (amount <= 0 || amount >= 99){
			throw new BusinessException(EnBusinessError.PARAMETER_VALIDATION_ERROR,"订单数量信息不合法");
		}
		if (promoId != null){
			if (itemModel.getPromoModel() == null || !itemModel.getPromoModel().getId().equals(promoId)){
				throw new BusinessException(EnBusinessError.PARAMETER_VALIDATION_ERROR, "活动信息不正确");
			}else if (itemModel.getPromoModel().getStatus() != 2){//不是正在秒杀中
				throw new BusinessException(EnBusinessError.PARAMETER_VALIDATION_ERROR, "活动信息不正确");
			}
		}
		
	    //落单减库存（使用），支付减库存
		boolean result = itemService.decreseStock(itemId, amount);
		
		if (!result){
			throw new BusinessException(EnBusinessError.STOCK_NOT_ENOUGH);
		}
		//写入数据库
		OrderModel orderModel = new OrderModel();
		orderModel.setUserId(userId);
		orderModel.setItemId(itemId);
		if (promoId != null){			
			orderModel.setItemPrice(itemModel.getPromoModel().getPromoItemPrice());
		}else{
			orderModel.setItemPrice(itemModel.getPrice());			
		}
		orderModel.setAmount(amount);
		orderModel.setOrderPrice(orderModel.getItemPrice().multiply(new BigDecimal(amount)));
		orderModel.setId(generateOrderNo());
		orderModel.setPromoId(promoId);
		
		
		//
		OrderInfo orderInfo = convertFromOrderModel(orderModel);
		orderInfoMapper.insertSelective(orderInfo);
		
		//落单加销量
		itemService.increaseSales(itemId, amount);
		
		//返回结果
		return orderModel;
	}
	
	private OrderInfo convertFromOrderModel(OrderModel orderModel){
		if (orderModel == null){
			return null;
		}
		OrderInfo orderInfo = new OrderInfo();
		BeanUtils.copyProperties(orderModel, orderInfo);
		return orderInfo;
	}
	
	//重新生成新的事务　
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	private String generateOrderNo(){
		//订单号１６位
		StringBuilder orderNo = new StringBuilder();
		//前8位为时间信息，年月日
		LocalDate now = LocalDate.now();
		String date = now.format(DateTimeFormatter.ISO_DATE).replaceAll("-", "");
		orderNo.append(date);		
		//中间6位为自增序列
		Sequence sequence = sequenceMapper.selectByName("order_info");
		int seqCurrentValue = sequence.getCurrentValue() + sequence.getStep();
		sequence.setCurrentValue(seqCurrentValue);
		sequenceMapper.updateByPrimaryKeySelective(sequence);
		
		String seqStr = String.valueOf(seqCurrentValue);
		for (int i=0; i< 6-seqStr.length(); i++){
			orderNo.append("0");
		}
		orderNo.append(seqStr);
		//后2位为分库分表位,暂时写死
		orderNo.append("00");
		return orderNo.toString();
	}

}
