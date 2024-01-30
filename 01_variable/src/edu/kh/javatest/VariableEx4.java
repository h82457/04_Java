package edu.kh.javatest;

public class VariableEx4 {
	// 메인 메서드 : 자바 프로그램 실행용 구문(기능)
	public static void main(String[] args) {
		
		/* 상수 : 한번 값을 기록하면 값을 바꿀 수 없는 변수
		 * 
		 *  상수 키워드 : final
		 *  
		 *  상수명 작성 : 대문자 작성, 연결되는 단어 사이는 '_' 구분
		 *  */
		
		final double PI = 3.1415926538;
		
		final int MIN = 0;
		final int MAX = 100;
		
		System.out.println("최소값 : " + MIN);
		System.out.println("최대값 : " + MAX);
		
	}
}
