package com.example.miaosha.validate;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component //类初始化时扫描该类
public class ValidatorImpl implements InitializingBean {
	
	@Autowired
	private Validator validator;//包装validator 
	
	public ValidationResult validate(Object bean){		
		ValidationResult result = new ValidationResult();		
		Set<ConstraintViolation<Object>> constraintset= validator.validate(bean);
		if (constraintset.size() > 0){
			//有错误
			result.setError(true);
			constraintset.forEach(constraint -> {
				String errMsg = constraint.getMessage();
				String propertyName = constraint.getPropertyPath().toString();
				result.getErrMsgMap().put(propertyName, errMsg);
			});				
		}		
		return result;		
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		//将Hibernate validator 通过工厂初始化方法实例化
		this.validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

}
