package com.example.demo.dao;


import java.util.List;

import com.example.demo.vo.OrderDetailVO;

public interface IOrderDetailDao {
	
	List<OrderDetailVO> listOrderDetail(Integer id);
	
	void updateOrderDetailById(Integer id);
}
