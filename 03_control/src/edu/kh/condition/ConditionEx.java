package edu.kh.condition;

import java.util.Scanner;

/**
 * 조건문 기능용 클래스
 */
public class ConditionEx {

	// 필드 (== 객체의 속성 == 객체가 가지고있는 값/변수)
	
	Scanner sc = new Scanner(System.in);
	
	
	/**
	 * 나이를 입력 받아 19세 이상은 "성인", 미만은 "성인이 아닙니다."
	 */
	public void method1() {
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		if(age >= 19) {
			System.out.println("성인");
		} else {
			System.out.println("성인이 아닙니다.");
		}
	}
	
	/**
	 * 나이를 입력 받아 13세 이하면 "어린이", 13세 초과 18세 이하 "청소년" 19세 이상 "성인" 
	 */
	public void method2() {
		System.out.println("나이 입력 : ");
		int age = sc.nextInt();
		
		String result;
		
		if(age <= 13) result = "어린이";
		else if(age <= 18) result = "청소년";
		else result = "성인";
				
		System.out.println(result);
	}
	
	/**
	 * 달(월)을 입력 받아 해당 계절 출력하기
	 * <ul>
	 * 	<li>봄   : 3,4,5</li>
	 * 	<li>여름 : 6,7,8</li>
	 * 	<li>가을 : 9,10,11</li>
	 * 	<li>겨울 : 12,1,2</li>
	 * 	<li>그 외 : 잘못 입력 </li>
	 * </ul>
	 */
	public void method3() {
		System.out.print("달(월) 입력 : ");
		int month = sc.nextInt();
		
		String result;
		if(month >= 3 && month <= 5) 				result = "봄";
		else if(month >= 6 && month <= 8) 	result = "여름";
		else if(month >= 9 && month <= 11) 	result = "가을";
		else if(month == 12 || month == 1 || month == 2) 	result = "겨울";
		else	result = "잘못 입력";
		
		System.out.println(result);
	}
	

	/**
	 * 생각하는 순서를 바꿈
	 */
	public void method3a() {
		System.out.print("달(월) 입력 : ");
		int month = sc.nextInt();
		
		String result;
		if(month < 1 || month > 12)  result = "잘못 입력";
		else if(month >= 3 && month <= 5) 	result = "봄";
		else if(month >= 6 && month <= 8) 	result = "여름";
		else if(month >= 9 && month <= 11) 	result = "가을";
		else result = "겨울";
		
		System.out.println(result);
	}
	
	/**
	 * 잘못된 경우에 메서드를 중간에 종료
	 */
	public void method3b() {
		System.out.print("달(월) 입력 : ");
		int month = sc.nextInt();
		
		if(month < 1 || month > 12) {
			System.out.println("잘못 입력");
			return; // 메서드를 종료하고 호출한 곳으로 돌아감
		}
		
		String result;
		if(month >= 3 && month <= 5) 	result = "봄";
		else if(month >= 6 && month <= 8) 	result = "여름";
		else if(month >= 9 && month <= 11) 	result = "가을";
		else result = "겨울";
		
		System.out.println(result);
	}
	
	public void method3c() {
		System.out.print("달(월) 입력 : ");
		int month = sc.nextInt();
		
		String result;
		
		switch(month) {
			case 3, 4, 5: result="봄"; break;
			case 6, 7, 8: result="여름"; break;
			case 9, 10, 11: result="가을"; break;
			case 12, 1, 2: result="겨울"; break;
			default : result="잘못 입력";
		}
		
		System.out.println(result);
	}

	/** P/F 판별하기
	 * <pre>
	 * 중간고사, 기말고사, 과제 점수를 입력 받아 총점 60점 이상일 경우 PASS, 아니면 FAIL
	 * 
	 * - 중간고사 (40%), 기말고사(50%), 과제 (10%)
	 * - 각각 100 만점
	 * 
	 * + PASS 인 경우 90점 이상 A, 80점 이상 B, 70점 이상 C, 60점 이상 D
	 * </pre>
	 */
	public void method4() {
		
		System.out.println("중간고사 점수 입력 : ");
		int mid = sc.nextInt();
		
		System.out.println("기말고사 점수 입력 : "); 
		int fin = sc.nextInt();
		
		System.out.println("과제 점수 입력 : ");
		int report = sc.nextInt();
		
		double result = (mid * 0.4) + (fin * 0.5) + (report * 0.1);
	
		// 변수에 아무런 값도 대입되지 않은 경우 사용 불가능(에러)
		// 해결 1) 모든 경우의 변수에 값을 대입
		// 해결 2) 변수 선언 시 특정한 값으로 초기화 진행 -> 숫자는 0, String은 null/"", boolean은 false, 이외의 객체는 null
		String grade = null;
		
		if (result < 60) grade = "FAIL";
		else {
			// switch의 매개변수로는 정수, 문자열만 가능
			switch((int)(result /10) ) {
			case 10: grade = "A"; break;
			case 9: grade = "A"; break;
			case 8: grade = "B"; break;
			case 7: grade = "C"; break;
			case 6: grade = "D"; break;
			}
		}
	
		System.out.println(grade);
	}
	
	/** <pre>
	 * 국어 영어 수학 사탐 과탐 점수를 입력 받아
	 * 40점 미만 과목이 있으면 FAIL
	 * 평균이 60점 미만인 경우도 FAIL
	 * 
	 * 모든 과목 40점 이상, 평균 60점 이상인 경우 PASS
	 * 
	 * 	[출력 예시]
	 * 1) 40점 미만 과목이 존재하는 경우 : FAIL [40점 미만 과목 : 국어 영어]
	 * 
	 * 2) 평균 60점 미만인 경우 : FAIL [점수 : 50.4 (평균 미달)]
	 * 
	 * 3) PASS인 경우 : PASS [점수 : 83.4 / 100]
	 * </pre>
	 */
	public void method5() {
		System.out.println("국어 점수 입력 : ");
		int s1 = sc.nextInt();
		
		System.out.println("영어 점수 입력 : ");
		int s2 = sc.nextInt();
		
		System.out.println("수학 점수 입력 : ");
		int s3 = sc.nextInt();
		
		System.out.println("사탐 점수 입력 : ");
		int s4 = sc.nextInt();
		
		System.out.println("과탐 점수 입력 : ");
		int s5 = sc.nextInt();
		
		int avg = (s1 + s2 + s3 + s4 + s5) / 5;
		String result = "", result1 = "";
		
		if (s1 < 40) {
			result = "FAIL";
			result1 += "국어";
		}
		if (s2 < 40) {
			result = "FAIL";
			result1 += "영어";
		}
		if (s3 < 40) {
			result = "FAIL";
			result1 += "수학";
		}
		if (s4 < 40) {
			result = "FAIL";
			result1 += "사탐";
		}
		if (s5 < 40) {
			result = "FAIL";
			result1 += "과탐";
		}
		
		if(avg < 60) {
			result = "FAIL";
			result1 += "평균 미만";
		} else result = "PASS";
		
		System.out.printf("%s 40점 미만 과목 : %s]", result, result1);
		
	}
	
}
