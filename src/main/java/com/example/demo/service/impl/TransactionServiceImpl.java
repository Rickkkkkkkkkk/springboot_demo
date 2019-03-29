package com.example.demo.service.impl;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.dao.IOrderDetailDao;
import com.example.demo.service.ITransactionService;

@Service(version = "1.0.0")
@Component
public class TransactionServiceImpl implements ITransactionService {
	
	@Autowired
	private IOrderDetailDao orderDEtailDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void test() {
		orderDEtailDao.updateOrderDetailById(3610);
		// 解决同一个service中只有方法入口能开启事务的问题
		((TransactionServiceImpl)AopContext.currentProxy()).test2();
	}
	
	
	public void test2() {
		
	}
}
