package com.tesfai.familyapp.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

//	// called before every method call
//	@Before("execution(public * com.example.FamilySite.controller.MemberController.*(..))")
//	public void logBefore() {
//		LOGGER.info(".......Method called Before.....");
//	}
//
//	// called after every method call irrespective of exception or return
//	// successfully
//	@After("execution(public * com.example.FamilySite.controller.MemberController.*(..))")
//	public void logAfter() {
//		LOGGER.info(".......Method called After.....");
//	}
//
//	// called after throwing an exception
//	@AfterThrowing("execution(public * com.example.FamilySite.controller.MemberController.*(..))")
//	public void logAfterThrowing() {
//		LOGGER.info(".......Method called After Throwing Exception.....");
//	}
//
//	// called after successful execution
//	@AfterReturning("execution(public * com.example.FamilySite.controller.MemberController.*(..))")
//	public void logAfterReturning() {
//		LOGGER.info(".......Method called After Returning  value.....");
//	}

	@Pointcut("execution(public * com.example.FamilySite.*.*.*(..))")
	public void appPointcut() {
		
	}
	
	@Around(value = "appPointcut()")
	public Object applicationLogger(ProceedingJoinPoint jointPoint) throws Throwable {
		
		ObjectMapper mapper=new ObjectMapper();
		
		String method = jointPoint.getSignature().getName();
		String className = jointPoint.getTarget().toString();
		Object[] args = jointPoint.getArgs();
		
		
		LOGGER.info("Class :"+className+"\nMethod : "+method+"\nArguments :"+mapper.writeValueAsString(args));
		
		Object object = jointPoint.proceed();
		LOGGER.info("Class :"+className+"\nMethod : "+method+"\nResponse :"+mapper.writeValueAsString(object));
		
		return object;

	}
}
