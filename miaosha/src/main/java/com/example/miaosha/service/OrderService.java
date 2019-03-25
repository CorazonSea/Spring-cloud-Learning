package com.example.miaosha.service;

import com.example.miaosha.error.BusinessException;
import com.example.miaosha.model.OrderModel;

public interface OrderService {

	OrderModel createOrder(Integer userId, Integer itemId, Integer promoId, Integer amount) throws BusinessException;
}
