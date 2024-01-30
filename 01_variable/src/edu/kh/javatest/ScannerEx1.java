package edu.kh.javatest;

import java.util.Scanner; // import 다른 패키지에 존재하는 클래스 가져오기

public class ScannerEx1 {
	public static void main(String[] args) {
		
		/* < Scanner 클래스 >
		 * - 사용자로부터 입력을 받기 위해 Jaca에서 제공하는 클래스
		 * - java.util 패키지에 존재 <- import 구문 작성 필요
		 * 
		 * ㄴ Scanner.next() : 단어(String) 1개 입력, 공백문자 입력시 입력 종료
		 * 
		 * ㄴ Scanner.nextLine() : 문자열(String) 1개 입력, 개행문자(enter) 입력시 종료
		 * 
		 * ㄴ Scanner.nextInt() : int 형 정수 1개 입력
		 * ㄴ Scanner.nextLong() : long 형 정수  1개 입력
		 * ㄴ Scanner.nextDouble() : 실수  1개 입력
		 * */
		
		/* Scanner 사용하기 */
		
		// 1. 클래스 위에 import 구문 작성
		
		// 2. import 한 Scanner 클래스를 이용, Scanner 객체 생성 * System.in : (이클립스) 키보드
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 1 : ");
		int num1 = sc.nextInt(); // 다음 입력된 정수를 얻어아 num1에 대입

		System.out.print("정수 입력 2 : ");
		int num2 = sc.nextInt(); // 다음 입력된 정수를 얻어아 num2에 대입
		
		System.out.print("실수 입력 : ");
		double num3 = sc.nextDouble(); // 다음 입력된 실수를 얻어아 num1에 대입
		
		System.out.print("단어 입력(2개) : "); 
		String word1 = sc.next(); // 2개 입력시 공백이 생기기때문에 next만 입력
		String word2 = sc.next();
		
		// ***************************
		// - next() / nextInt() / nextDouble() 등을 작성 이후 nextLine() 을 작성해야하는 상황이 오면 nextLine() 을 미리 한번 작성하기
		
		/* Scanner 사용시 입력되는 값이 Scanner의 입력 버퍼에 저장 + nextInt() 면 버퍼에 저장된 값 중 정수만 추출 <- 정수와 같이 입력된 엔터는 버퍼에 계속 존재,
		이후 nextLine() 해석시에 버퍼에서 다음 엔터까지 읽어오는 작업이 수행되는데 버퍼에 남아있던 엔터를 읽어오기때문에 입력 불가 */
		
		// [해결 방법] nextLine() 한번 호출해서 남아있던 엔터를 제거
		sc.nextLine();
		
		// ***************************
	
		System.out.print("문장 입력 : ");
		String str = sc.nextLine();
		
		System.out.printf("%d, \t\t %d, %f, %s, %s, %s \\ \" \' \n", num1, num2, num3, word1, word2, str);
	}	
}
