package edu.kh.javatest;

public class VariableEx2 {
	public static void main(String[] args) {
		
		/* 컴퓨터의 값 처리 원칙 : 같은 자료형끼리 연산, 결과도 같은 자료형
		 * 
		 *		< 형변환 >
		 * - 다른 자료형끼리 연산하는 경우 자료형을 맞게 변환
		 * 
		 * ** < 자동 형변환 > **
		 * - 연산시 값의 범위가 작은 자료형을 값의 범위가 '큰' 자료형으로 자동 변환
		 * */

		
		/* 자동 형변환 확인 1 */
		int num1 = 9;
		long num2 = 1_000_000_000L; // 가독성을 위해 _ 사용 가능, 오류X
		
//		int result1 = num1 + num2; // num1 <- int , num2 <- long. 자동 형변환시 큰 자료형인 long으로 변환되어 결과도 long으로 계산. int 형 변수인 result1에 long을 대입하려고해서 오류가 발생
		long result1 = num1 + num2;
		System.out.println("result1 : " + result1);
		
		
		/* 자동 형변환 확인 2 */
		int num3 = 300;
		double num4 = 12.34;
		// (int)300.0 = (double)14 -> (dobule) 300 + (dub

		
		/* 자동 형변환 확인 3 */
		long num5 = 20L;
		float num6 = 3.14f;
		
		// (long) 20.0L + (float) 3.14f = (double) = (double) 23.14f;
		double result3 = num5 + num6;

		
		System.out.println("result3 : " + result3);
		
		// double, float 는 실수를 근사지추로 현한 자료형, 정확하지않다. (부동소소점 문제)
	}
}
