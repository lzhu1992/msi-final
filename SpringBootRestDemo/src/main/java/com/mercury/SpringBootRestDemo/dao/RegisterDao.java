package com.mercury.SpringBootRestDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SpringBootRestDemo.bean.Register;


public interface RegisterDao extends JpaRepository<Register, String> {
	 Register findByEmail(String email);
}
