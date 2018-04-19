package com.mercury.SpringBootRestDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SpringBootRestDemo.bean.Product;
import com.mercury.SpringBootRestDemo.service.ProductService;

//spring4
//@controller + responsebody, return json data result saved at responsebody
@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	@GetMapping("/products")
	public List<Product> handleGetProducts() {
		return productService.getAllProducts();
	}
}
