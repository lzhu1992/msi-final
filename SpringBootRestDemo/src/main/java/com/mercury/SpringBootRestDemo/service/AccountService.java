package com.mercury.SpringBootRestDemo.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mercury.SpringBootRestDemo.bean.Account;
import com.mercury.SpringBootRestDemo.bean.Login;
import com.mercury.SpringBootRestDemo.bean.Register;
import com.mercury.SpringBootRestDemo.bean.Transaction;
import com.mercury.SpringBootRestDemo.bean.Transfer;
import com.mercury.SpringBootRestDemo.dao.AccountDao;
import com.mercury.SpringBootRestDemo.dao.RegisterDao;
import com.mercury.SpringBootRestDemo.dao.TransactionDao;
import com.mercury.SpringBootRestDemo.http.Response;

@Transactional
@Service
public class AccountService {
     @Autowired
     TransactionDao transactionDao;
      @Autowired
      RegisterDao registerDao;
      @Autowired
      AccountDao accountDao;
//      @Autowired
//      Transaction transaction;
     
     
      
      public Account getDeposit(String email){
   	      Register register = registerDao.findByEmail(email);
   	      if(register != null){
   	    	  Account account = accountDao.findByAccount(register.getAccount());
   	    	  return account;
   	      }
   	      else return null;
   	     
      }
      public List<Transaction> getTransaction(String email){
   	      Register register = registerDao.findByEmail(email);
   	      if(register != null){
   	    	  return transactionDao.findByAccount(register.getAccount());
   	      }
   	      else return null;
   	     
      }
      public ByteArrayInputStream getProductsInPDF() {
  		ByteArrayOutputStream out = new ByteArrayOutputStream();
  		Document document = new Document();
  		try {
  			PdfPTable table = new PdfPTable(5);
  			
  			Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
  			PdfPCell hcell;
  			hcell = new PdfPCell(new Phrase("Date", headFont));
  			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
  			table.addCell(hcell);
  			hcell = new PdfPCell(new Phrase("Recipient", headFont));
  			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
  			table.addCell(hcell);
  			hcell = new PdfPCell(new Phrase("Amount", headFont));
  			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
  			table.addCell(hcell);
  			hcell = new PdfPCell(new Phrase("Deposit", headFont));
  			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
  			table.addCell(hcell);
  			hcell = new PdfPCell(new Phrase("Describe", headFont));
  			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
  			table.addCell(hcell);
//  		    Register register = registerDao.findAll();
  			for(Transaction p : transactionDao.findAll()) {
  				PdfPCell cell;

                  cell = new PdfPCell(new Phrase(p.getTdate()));
                  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                  cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                  table.addCell(cell);
                  
                  cell = new PdfPCell(new Phrase(p.getRecipient()));
                  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                  cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                  table.addCell(cell);
                  
                  cell = new PdfPCell(new Phrase(Integer.toString(p.getAmount())));
                  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                  cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                  table.addCell(cell);
                  
                  cell = new PdfPCell(new Phrase(Integer.toString(p.getDeposit())));
                  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                  cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                  table.addCell(cell);
                  
//                  cell = new PdfPCell(new Phrase(Integer.toString(p.getDescribe())));
//                  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                  cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                  table.addCell(cell);
  			}
  			
  			PdfWriter.getInstance(document, out);
  			document.open();
  			document.add(table);
  		} catch (DocumentException e) {
  			e.printStackTrace();
  		} finally {
  			document.close();
  		}
  		return new ByteArrayInputStream(out.toByteArray());
  	}

      public Response updateDeposit(Transfer transfer,Login login){
    	  System.out.println(transfer);
    	  System.out.println(login);
    	  Register recipient = registerDao.findByEmail(transfer.getRecipient());
    	  Register sender = registerDao.findByEmail(login.getEmail());
    	  Account accountr = accountDao.findByAccount(recipient.getAccount());
    	  Account accounts = accountDao.findByAccount(sender.getAccount());
    	  accountr.setAmount(accountr.getAmount() + transfer.getAmount());
    	  accounts.setAmount(accounts.getAmount() - transfer.getAmount());
  	       
    	  
    	  
    	  List<Transaction> rts = transactionDao.findAll();
    	  int size = rts.size();
    	  
    	  Transaction rtransaction = new Transaction(size+1,accountr.getAccount(),"2018-04-18", sender.getEmail(),transfer.getAmount(),accountr.getAmount(),"online transfer");
    	  Transaction stransaction = new Transaction(size+2,accounts.getAccount(),"2018-04-18", recipient.getEmail(),0-transfer.getAmount(),accounts.getAmount(),"online transfer");
    	  transactionDao.save(rtransaction);
    	  transactionDao.save(stransaction);
    	  
    	  
    	  return new Response(true);
      }
}
