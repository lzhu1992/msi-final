package com.mercury.SpringBootRestDemo.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerLoggingAspect {
	@Pointcut("execution(* com.mercury.SpringBootRestDemo.controller.*.*(..))")
	//*return type can be anything, second* means any class and the third means any method
	public void controllerMethods() {}
		//after the selected method finished executing
		@After("controllerMethods()")
		public void afterAdvice(JoinPoint jp) {
			System.out.println(jp.getSignature().getName()+"was invoked!");
		}
}
