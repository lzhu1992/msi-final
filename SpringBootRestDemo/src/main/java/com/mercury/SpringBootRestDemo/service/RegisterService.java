package com.mercury.SpringBootRestDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.SpringBootRestDemo.bean.Login;
import com.mercury.SpringBootRestDemo.bean.Register;
import com.mercury.SpringBootRestDemo.dao.AccountDao;
import com.mercury.SpringBootRestDemo.dao.RegisterDao;
import com.mercury.SpringBootRestDemo.http.Response;

@Transactional
@Service
public class RegisterService {
       @Autowired
       RegisterDao registerDao;
       @Autowired
       AccountDao accountDao;
        
       public Response addUser(Register register){
    	  // if(accountDao.findById(register.getAccount())!= null){
    		   registerDao.save(register);
    		 
    		   return new Response(true);
    	  // }
//    	   else
//    		   return new Response(false);
//       }
       }
       
       public Response login(Login login){
    	   Register register = registerDao.findByEmail(login.getEmail());
    	   if(register!= null && register.getPassword().equals(login.getPassword())) {
    		   System.out.println("login success");
    		   return new Response(true);
    	   }
    	   else
    		   return new Response(false);	  
   		  
       }
       
}
