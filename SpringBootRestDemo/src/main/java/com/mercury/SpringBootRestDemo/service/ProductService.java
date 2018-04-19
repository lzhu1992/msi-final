package com.mercury.SpringBootRestDemo.service;
import java.util.List;

import org.hibernate.boot.model.relational.ExportableProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;// inherit addcomponent
import org.springframework.transaction.annotation.Transactional;

import com.mercury.SpringBootRestDemo.bean.Product;
import com.mercury.SpringBootRestDemo.dao.ProductDao;
import com.mercury.SpringBootRestDemo.jms.EmailProducer;

@Service
@Transactional
public class ProductService {
	@Autowired
	ProductDao productDao;
	@Autowired
	EmailProducer emailProducer;
	//autowired the interfaced whoever implement it will be autowired
	public List<Product> getAllProducts() {
		emailProducer.send("You visited all the products!");// send to email queue
		return productDao.findAll();
	}
	public void addProduct() {
		//multiple transaction , each user will use these method
	}
}
