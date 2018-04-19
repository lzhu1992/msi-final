package com.mercury.SpringBootRestDemo.jms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
@Component
public class EmailProducer {
       @Autowired 
       JmsTemplate jmsQueueTemplate;
       public void send(String message) {
    	   	 //emailQueue
    	     jmsQueueTemplate.convertAndSend("emailQueue",message);
       }
}
