package com.mercury.SpringBootRestDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SpringBootRestDemo.bean.Account;

public interface AccountDao extends JpaRepository<Account, Integer> {
	   Account findByAccount(Integer account);
}
