package com.yedam.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterReturningAdvice {
	
	
	@Pointcut("execution(* com.yedam.app..*Impl.select*(..))") 
	 public void selectPointcut() {}
	
	//@AfterReturning(pointcut="selectPointcut()", returning="returnObj")
	@AfterReturning(pointcut="LogAdvice.allpointcut()", returning="returnObj") //다른거에 있는 pointcut 사용도 가능
	public void afterLog(JoinPoint jp, Object returnObj){
		String method = jp.getSignature().getName();
		String result = returnObj != null ? returnObj.toString() : "";

		System.out.println("[사후처리] 로직 수행 후 동작" +
		                    method + " : " + 
		                    result );
	}
	
	
}
