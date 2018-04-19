package com.mercury.SpringBootRestDemo;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class SpringBootRestDemoApplication {
	@Value("${jms.broker-url}")
	private String jmsBrokerUrl;
	@Value("${jms.user}")
	private String jmsUser;
	@Value("${jms.password}")
	private String jmsPassword;
	@Bean
	public ConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(jmsBrokerUrl);
		connectionFactory.setUserName(jmsUser);
		connectionFactory.setPassword(jmsPassword);
		return connectionFactory;
	}
	
	@Bean
	public JmsTemplate jmsQueueTemplate(){//send message
		return new JmsTemplate(connectionFactory());
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestDemoApplication.class, args);
	}
}
