package com.mercury.SpringBootRestDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import com.mercury.SpringBootRestDemo.bean.TransRequest;
import com.mercury.SpringBootRestDemo.bean.Transaction;
import com.mercury.SpringBootRestDemo.dao.TransactionDao;
import com.mercury.SpringBootRestDemo.http.Response;
import com.mercury.SpringBootRestDemo.service.AccountService;
@CrossOrigin
@RestController
public class TransactionController {
	@Autowired
	AccountService accountService;
	@Autowired 
	TransactionDao transactionDao;
	
	
//	@PostMapping("/deposit")
//	public int getDeposit(@RequestBody String email){
//		return accountService.getDeposit(email).getAmount();
//	}
//	@GetMapping("/transaction/{email}")
//	public List<Transaction> getTransaction(@PathVariable String email){
//		
//	}
	   
	 @GetMapping("/transaction/{email}")
       public List<Transaction> getTransaction(@PathVariable String email){
   	     return accountService.getTransaction(email);
     }
	 @PostMapping("/transfer")
		public Response getTransfer(@RequestBody TransRequest transRequest){
		    return accountService.updateDeposit(transRequest.getTransfer(), transRequest.getLogin());
			//return new Response(true);
		}
	 @GetMapping(value = "/transaction_pdf", produces = MediaType.APPLICATION_PDF_VALUE)
		public ResponseEntity<InputStreamResource> getProductsInPDF(@PathVariable String email) {
		    HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "inline; filename=products.pdf");

			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(accountService.getProductsInPDF()));
		}

 
}
