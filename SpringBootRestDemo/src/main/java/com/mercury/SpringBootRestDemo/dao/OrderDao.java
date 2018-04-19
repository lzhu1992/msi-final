package com.mercury.SpringBootRestDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RestResource;

import com.mercury.SpringBootRestDemo.bean.Order;
//don't need to write the controller, delete and add
//@RestResource(path="orders", rel="orders")
public interface OrderDao extends JpaRepository<Order,Integer> {
	
}
