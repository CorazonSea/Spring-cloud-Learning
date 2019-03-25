package com.example.miaosha.service;

import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.miaosha.dao.PromoMapper;
import com.example.miaosha.entity.Promo;
import com.example.miaosha.model.PromoModel;

@Service
public class PromoServiceImpl implements PromoService {

	@Autowired
	private PromoMapper promoMapper;
	
	@Override
	public PromoModel getPromoByItemId(Integer itemId) {
		// TODO Auto-generated method stub
		//获取即将开始，或者正在进行中的秒杀活动
		Promo promo = promoMapper.selectByItemId(itemId);
		PromoModel  promoModel = convertFromPromo(promo);
		
		return promoModel;
	}

	private PromoModel convertFromPromo(Promo promo){
		if (promo == null){
			return null;
		}
		PromoModel promoModel =  new PromoModel();
		BeanUtils.copyProperties(promo, promoModel);
		promoModel.setStartTime(new DateTime(promo.getStartTime()));
		promoModel.setEndTime(new DateTime(promo.getEndTime()));
		DateTime now = new DateTime();
		if (promoModel.getStartTime().isAfter(now)){
			promoModel.setStatus(1);//活动未开始
		}else if (promoModel.getEndTime().isBefore(now)){
			promoModel.setStatus(3);//活动已经结束
		}else{
			promoModel.setStatus(2);//活动正在进行中
		}		
		return promoModel;
	}
}
