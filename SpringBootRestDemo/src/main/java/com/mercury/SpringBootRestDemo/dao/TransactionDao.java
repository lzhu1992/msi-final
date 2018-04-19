package com.mercury.SpringBootRestDemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SpringBootRestDemo.bean.Transaction;

public interface TransactionDao extends JpaRepository<Transaction, Integer> {
	
	List<Transaction> findByAccount(Integer account);
	
}
