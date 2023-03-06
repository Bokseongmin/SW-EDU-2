package org.comstudy.myweb.common;

public class LogAdvice {
	public void printLogging() {
		// AOP Pointcut으로 검색된 기능에 추가되는 기능.
		System.out.println(">>>> printLoging() : 임시 내용 ...");
	}
	
	public void afterLogging() {
		System.out.println(">>>> afterLogging() : 서비스 처리 후 실행 ...");
	}
}
