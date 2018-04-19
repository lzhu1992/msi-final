package com.mercury.SpringBootRestDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SpringBootRestDemo.bean.Order;
import com.mercury.SpringBootRestDemo.dao.OrderDao;

@RestController
public class OrderController {
	@Autowired
	OrderDao orderDao;
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")//Order authorization
	@GetMapping("/orders")
	public List<Order> getOrders() {
		return orderDao.findAll();
	}
}
