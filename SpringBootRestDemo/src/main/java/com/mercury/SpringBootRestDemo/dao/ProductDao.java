package com.mercury.SpringBootRestDemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mercury.SpringBootRestDemo.bean.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {
//jpa automatically implement productdao
//JPQL 
	public List<Product> findByName(String name);
	@Query("select max(p.price) from Product p")
	public int getMaxPrice();
	@Query("select p from  Product p where p.stock > :stock")
	public List<Product> getProductsWithStock(@Param("stock")int stock);
}
