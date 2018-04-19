package com.mercury.SpringBootRestDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SpringBootRestDemo.bean.Account;
import com.mercury.SpringBootRestDemo.bean.Login;
import com.mercury.SpringBootRestDemo.bean.Register;
import com.mercury.SpringBootRestDemo.dao.RegisterDao;
import com.mercury.SpringBootRestDemo.http.Response;
import com.mercury.SpringBootRestDemo.service.AccountService;
import com.mercury.SpringBootRestDemo.service.RegisterService;
@CrossOrigin
@RestController
public class RegisterController {
      @Autowired
      RegisterService registerService;
      @Autowired
      RegisterDao registerDao;
      @Autowired
      AccountService accountService;
  @PostMapping("/login")
      public Response isUser(@RequestBody Login login){
    	  return registerService.login(login);
    	   //return new Response(true);
      }
      @GetMapping("/register")
      public List<Register> getRegisters(){
    	  return registerDao.findAll();
      }
      
      @GetMapping("/test")
      public boolean getRegister1(){
    	  System.out.println("hello");
    	  return true;
      }
        
      @PostMapping("/register")
      public Response addUser(@RequestBody Register register){
    	  System.out.println("login");
    	  return registerService.addUser(register);
      }
     @GetMapping("/deposit/{email}")
     public Account getDeposit(@PathVariable String email){
    	 	System.out.println(email);
   	   return accountService.getDeposit(email);
     }      
      
     
}
