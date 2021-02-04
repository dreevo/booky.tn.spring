package tn.booky.corp.config;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	Logger logger = LogManager.getLogger(LoggingAspect.class);
	
	@Before("execution (* tn.booky.corp.services.BookServiceImpl.*(..))")
	public void logServices (JoinPoint joinpoint) {
		String name = joinpoint.getSignature().getName();
		logger.warn("Accessing service method : "+name);
	}
	
	@AfterReturning("execution(* tn.booky.corp.services.BookServiceImpl.*(..))")
	public void logMethodExit (JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		logger.info("successfully out of service method :" +name);
	}

}
