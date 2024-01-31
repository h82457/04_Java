package edu.kh.loop;

import java.util.Scanner;

/**
 * 중첩 반복문
 */
public class LoopEx2 {
	
	Scanner sc = new Scanner(System.in);
	
	/**<pre>
	 * 다음 모양 출력하기
	 * 
	 * 1234
	 * 1234
	 * 1234
	 * </pre>
	 */
	public void method1(){
		
		for(int j=3 ; j>=1 ; j--) {
			for(int i=1 ; i <= 4 ; i++) {
				System.out.print(i);
			}
			System.out.println(); // 줄바꿈
		}
	}
	
	/**<pre>
	 * 다음 모양 출력하기
	 * 
	 * 4321
	 * 4321
	 * </pre>
	 */
	public void method2() {
		
		for(int j=0 ; j<2 ; j++) {
			for(int i=4 ; i>0 ; i--) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
	
	/**<pre>
	 * 다음 모양 출력하기
	 * 
	 * (0,0) (0,1) (0,2)
	 * (1,0) (1,1) (1,2)
	 * (2,0) (2,1) (2,2)
	 * </pre>
	 */
	public void method3() {
		
		for(int j=0 ; j<=2 ; j++) {
			for(int i=0 ; i<=2 ; i++) {
				System.out.printf("(%d,%d) ", j,i);
			}
			System.out.println();
		}

	}
	
	/**<pre>
	 * 다음 모양 출력하기
	 * 
	 * (2,2) (2,1) (2,0)
	 * (1,2) (1,1) (1,0)
	 * (0,2) (0,1) (0,0)
	 * </pre>
	 */
	public void method4() {
		for(int j=2 ; j>=0 ; j--) {
			for(int i=2 ; i>=0 ; i--) {
				System.out.printf("(%d,%d) ", j,i);
			}
			System.out.println();
		}
	}
	
	/**
	 * 2단 부터 9단까지 모두 출력
	 * 
	 * 2x1= 2  2x2= 4  2x3= 6 ... 2x9=18
	 * 3x1= 3  3x2= 6  3x3= 9 ... 3x9=27
	 * ...
	 * 9x1= 9  9x2=18  9x3=27 ... 9x9=81
	 */
	public void method5() {
		
		for(int j=2 ; j<=9 ; j++) {
			for(int i=1 ; i<=9 ; i++) {
				System.out.printf("%dx%d=%2d ",j,i,j*i);
			}
			System.out.println();
		}
		
	}
	
	/**<pre>
	 *  입력 받은 단부터 9단까지 구구단 출력하기
	 *  단, 입력값이 2~9 사이가 아니면 "잘못 입력" 출력
	 *  ex)
	 *  단 입력 (2~9사이) : 7
	 *  
	 * ===== 7단 =====
	 * 7 x 1 =  7
	 * 7 x 2 = 14
	 * ...
	 * 7 x 9 = 63
	 * 
	 * ===== 8단 =====
	 * ...
	 * ===== 9단 =====
	 * </pre>
	 */
	public void method6() {
		
		System.out.print("단 입력 (2~9사이) : ");
		int num = sc.nextInt(); 
		
		if(num < 2 || num>9) {
			System.out.println("잘못 입력");
			return;
		}
		
		for(int j=num ; j<=9 ; j++) {
			System.out.printf("===== %d단 ===== \n", j);
			
			for(int i=num ; i<=9 ; i++) {
				System.out.printf("%d x %d = %2d \n", j, i, j*i);
			}
		}
	}
	/**<pre>
	 * 1 2 3
	 * 4 5 6
	 * 7 8 9
	 * </pre>
	 */
	public void method7() {
		
		int count = 1;
		
		for(int j=0 ; j<3 ; j++) {
			
			for(int i=0;  i<3 ; i++) System.out.print(count++ + " ");
			
			System.out.println();
		}
	}
	
	/**<pre>
	 *  ****
	 *  ****
	 *  ****
	 *  ****
	 * </pre>
	 */
	public void method8() {

		for(int j=0 ; j<4 ; j++) {
			for(int i=0; i<4 ; i++) System.out.printf("*");

			System.out.println();
		}
	}
	/**<pre>
	 * *
	 * **
	 * ***
	 * ****
	 * </pre>
	 */
	public void method9() {
		
		for(int j=1 ; j<=4 ; j++) {
			for (int i=0 ; i<j ; i++) System.out.print("*");
			System.out.println();
		}
	}
	
	/**<pre>
	 * ****
	 * ***
	 * **
	 * *
	 * </pre>
	 */
	public void method10() {
		for(int j=4 ; j>=1 ; j--) {
			for (int i=0 ; i<j ; i++) System.out.print("*");
			System.out.println();
		}
	}
}
