package edu.kh.exception.pack3.model.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.kh.exception.pack3.model.exception.MoreThanAHundredException;

public class ExceptionHandlingService3 {
	
	/* Checked EXception / UnChecked EXception
	 * 
	 * Check : 확인하다
	 * 
	 * - Checked Exception : 반드시 확인 필요한 예외
	 * 	-> 예외 처리 구문(try-catch, throws)을 반드시! 작성이 필요한 예외
	 * 
	 * - UnChecked Exception : 확인 안해도 되는 예외
	 * 	-> 예외 처리 구문(try-catch, throws)을 써도 그만, 안써도 그만인 예외
	 * */
	
	/**
	 * Checked / UnChecked 구분하기
	 */
	public void method1() {
		
		/* UnChecked EXception */
		// RuntimeException 또는 RuntimeException의 자식 예외 강제 발생
		
		int result = 1;
		
		if(result ==1) {
			throw new RuntimeException(); // <- 빨간 줄 안뜸
		}
		
		/* Checked EXception */
		// RuntimeException- RuntimeException의 자식 제외한 나머지 예외 강제 발생
		
		else {
			try {
				throw new IOException(); // <- 빨간 줄(컴파일 에러)확인
//				ㄴ>오류 문구 : Unhandled exception type IOException, 예외 처리 필요(try-catch, throws)
			}catch(IOException e) {
				System.out.println("예외 처리 필수!!");
			}
		}
	}
	
	/**
	 * Checked Exeption 확인하기
	 * - 이미 만들어져 있는 Java 코드 이용시 예외처리가 꼭 필요한 경우
	 */
	public void method2() {
		
//		BufferedReader: 효율적으로 읽어오는 객체
//		InputStreamReader(System.in) : 키보드 입력을 읽는 객체 /  System.in : 키보드
		
//		-> Scanner 에 비해 기능이 부족하나 속도가 압도적으로 빠르다
//		--> 부족한 기능(int, double 입력받기)은 Integer.parseInt(문자열), Double.pareseDouble(문자열) 이용
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.print("문자열 입력 : ");
		
//		String input = br.readLine(); // 입력된 한 줄 입력 (엔터 입력 전까지)
//						ㄴ> 컴파일 에러, public String readLine() throws IOException
//							ㄴ>IOException 예외처리 구문 필수 작성!
		
		// br.readLine() 사용 위해 작성한 IOException 예외처리 구문
		try {
			String input = br.readLine();
			System.out.println("입력 받은 문자열 : " + input);
			
		}catch(IOException e){
			System.out.println("예외 잡아서 처리");
		}
	}
	
	/**
	 * CheckedException, UnCheckedException 두종류 예외가 섞인 예제
	 */
	public void method3() {
		
		// BufferedReader 이용해서 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = null; // null: 참조형 변수의 기본값
		
		try {
			// 입력 받기
			System.out.print("입력 : ");
			input = br.readLine(); // CheckedException
			
			// 입력 받은 내용이 정수 -> *2해서 출력하기, 입력 받은 내용이 문자열 -> 앞 뒤에 ### 붙이기
			
			// 입력 받은 문자열 input을 정수로 변환 (parse : 강제로 변환)
			int temp = Integer.parseInt(input); // UnChecked Exception
			System.out.println(temp*2);
			
			// 문자열 입력 -> java.lang.NumberFormatException 오류 발생
//				ㄴ 파싱하려는 문자열 input이 숫자의 형태 X - > 변환 불가 -> 문자열은 catch에서 처리
		}
		
		catch(IOException e) {	System.out.println("IOException 처리");	}
		
		// 정수가 아닌 문자열이 입력되어 NumberFormatException 발생 경우 (문자열 입력시)
		catch(NumberFormatException e) {	System.out.println("###" + input + "###");	}
	}
	
	/**
	 * - throws  : 메서드 내부에서 발생된 예외를 >호출한 곳<으로 던짐 
	 * 
	 * - throw   : 예외 객체를 (강제로) 현재 위치에서 던짐 (예외 강제 발생)
	 */
	public void method4() {
		
		// input String() 메서드를 이용해서 문자열을 두번 입력 받고 하나로 합쳐서 출력
		
		try {
			System.out.print("첫번째 문자열 입력 : ");
			String str1 = inputString(); // str값 전달
//			 ㄴ> inputString() 호출 -> throws IOException 에 대한 예외 처리 코드 작성 필요 (try-catch / throws)
			
			System.out.print("두번째 문자열 입력 : ");
			String str2 = inputString();
			
//			System.out.println(str1 + str2); <- 효율 낮음
			
			StringBuilder sb = new StringBuilder();
			sb.append(str1);
			sb.append(str2);
			
			System.out.println(sb.toString());
			
		}catch(IOException e) { System.out.println("IOException 처리");	}

	}
	
	/** BufferedReader 를 이용해서 문자열 입력 받기
	 * @return 입력 받은 문자열
	 */
	public String inputString() throws IOException{ // 예외 구문을 호출한곳으로 던짐
//									^ㄴ throws IOException : 현재 메서드에서
//		발생할 수 있는 IOExceptiond을 현재 메서드를 호출한 곳으로 단져서 상황에 맞게 별도로 처리
		
		// BufferedReader로 입력값 받아오기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
// 		System.in 은 한번 닫으면 재사용 불가!		
//		br.close(); // 사용 끝난 br 객체 메모리 반환(제거)
		
		return str;
	}
	
	/**
	 * 사용자 정의 예외 사용
	 */
	public void method5(){
		try {
			System.out.println("[두 정수 입력 받아 합계 출력하기]");
			
			System.out.print("정수 1 : ");
			int num1 = Integer.parseInt(inputString()); // str 값 받아 int 변환+저장

			System.out.print("정수 2 : ");
			int num2 = Integer.parseInt(inputString());
			
			
			int result = num1 + num2;
			
			if(result > 100) { // 100 초과한 경우가 심각한 상황으로 가정
//				throw new MoreThanAHundredException();
				throw new MoreThanAHundredException("100을 초과하다니.....");
			}
			
			System.out.println(result); // 결과 출력
		}
		
		catch(IOException e) {	System.out.println("IOException 처리");	}
		
		// 정수가 아닌 다른 타입 - NumberFormatException
		catch(NumberFormatException e) {	System.out.println("잘못 입력");	}
		
		catch(MoreThanAHundredException e) {
//			 e : 예외 객체 참조 변수
			
//			 e.printStackTrace()
//			 - print : 출력하다
//			 - Stack : JVM 메모리 중 Stack 영역(메서드가 쌓여있음)
//			 - Trace : 추적하다
			
//			-> 호출한 메서드 순서대로 발생한 예외를 모두 추적해서 출력
			
			e.printStackTrace();
		}
	}
}
