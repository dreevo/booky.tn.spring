package tn.booky.corp.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class PerformanceAspect {

	Logger logger = LogManager.getLogger(PerformanceAspect.class);

	@Around("execution (* tn.booky.corp.services.OrderServiceImpl.*(..))")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		Object obj = pjp.proceed();
		long elapsedTime = System.currentTimeMillis() - start;
		logger.info("Method execution time: " + elapsedTime + " milliseconds.");
		return obj;
	}
}
