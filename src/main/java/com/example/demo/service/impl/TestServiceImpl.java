package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.IOrderDetailDao;
import com.example.demo.service.TestService;
import com.example.demo.vo.OrderDetailVO;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	private IOrderDetailDao orderDetailDao;
	
	@Transactional
	public void test() {
		List<OrderDetailVO> orderDetails = orderDetailDao.listOrderDetail(3609);
		System.out.println(orderDetails.get(0).getItemsId());
		
		orderDetailDao.updateOrderDetailById(3609);
//		throw new RuntimeException();
	}
}
