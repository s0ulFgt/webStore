//package cn.tedu.store.aop;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
//@Component
//@Aspect
//public class TimeElapsedAspect {
//
//	private long startTime;
//	
//	@Around("execution(* cn.tedu.store.service.impl.*.*(..))")
//	public Object around(ProceedingJoinPoint pjp) throws Throwable {
//		// ִ��ǰ������
//		doBefore();
//		
//		// ����ԭ��Ӧ��ִ�еķ���
//		Object result = pjp.proceed();
//		
//		// ִ�к�������
//		doAfter();
//		
//		// ����ԭ��Ӧ��ִ�еķ����ķ���ֵ
//		return result;
//	}
//	
//	public void doBefore() {
//		System.out.println("TimeElapsedAspect.doBefore()");
//		startTime = System.currentTimeMillis();
//	}
//	
//	public void doAfter() {
//		long endTime = System.currentTimeMillis();
//		long elapsed = endTime - startTime;
//		System.out.println("TimeElapsedAspect.doAfter() : " + elapsed);
//	}
//	
//}
//
//
//
//
//
//
//
