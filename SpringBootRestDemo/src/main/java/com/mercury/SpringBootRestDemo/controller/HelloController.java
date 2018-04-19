package com.mercury.SpringBootRestDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Component
@Controller
public class HelloController {
	@RequestMapping("/hello")
	@ResponseBody()
	//return json format data
	public String sayHello() {
		return "Hello World!";
	}
}
