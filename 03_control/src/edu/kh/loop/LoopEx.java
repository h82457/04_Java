package edu.kh.loop;

import java.util.Scanner;

public class LoopEx {
	
	// 필드 (객체의 속성 == 객체의 변수)
	// java.util.Scanner
	Scanner sc = new Scanner(System.in);
	/**
	 * 1부터 10까지 출력
	 */
	public void method1() {
		
		for(int i = 1 ; i <= 10 ; i++ ) {
			System.out.println(i);
		}
	}
	
	/**
	 * 첫번째 입력받은 수 부터 두번째 입력 받은 수까지 1씩 증가하며 출력
	 */
	public void method2() {
		System.out.print("입력 1 2: ");
		int input1 = sc.nextInt();
		int input2 = sc.nextInt();
		
		for(int i=input1 ; i <-input2 ; i++) {
			System.out.println(i);
		}
	}
	
	/**
	 * 10부터 1까지 1씩 감소하며 출력
	 */
	public void method3() {
		for(int i=10 ; i>0 ; i++) {
			System.out.println(i);
		}
	}
	
	/**
	 * 두 수를 입력받아 반복 출력하는 구문 작성 (첫번째 입력 a,b)
	 * 조건 1) b가 a 보다 큰 경우 -> a에서 b까지 1씩 증가하며 출력
	 * 2)a가 b 보다 큰경우 -> a 에서 b까지 1씩 증가하며 출력
	 * 3) a와 b가 같다면 같은 수 입력됨 출력
	 * 	 */
	public void method4() {
		
		System.out.println("입력 1 2 : ");
		int a =sc.nextInt(); 
		int b =sc.nextInt(); 
		
		if(a == b) {
			System.out.println("같은 수 입력됨");
			return;
		}
		
		
		if(b>a) {
			for(int i=a ; i < b ; i++) System.out.println(i);
		}else {
			for(int i=a ; i > b; i--) System.out.println(i);
		}
	}
	
	/**
	 * 두 수를 입력받아 1씩 증가 + 반복 출력 (첫번째 입력 a,b)
	 * 입력받은 두 수중 작은값이 초기식, 큰값이 조건식에 사용되게 작성 (같은 경우는 초기식 a 조건식 b)
	 */
	public void method5a() {
		System.out.println("입력 1 2 : ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int min, max;
		
		
		if(a<=b) {
			min = a;
			max = b;
			
		} else {
			min = b;
			max = a;
		}
		
		for(int i=min ; i<=max ; i++) System.out.println(i);
	}
	/**
	 * 최대, 최소값 구하기 V2 (Math)
	 */
	public void method5b() {
		System.out.println("입력 1 2 : ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int min = Math.min(a, b); // 두 수중 작은 값 반호ㅘㄴ
		int max = Math.max(a, b);
		
		for(int i=min ; i<=max ; i++) System.out.println(i);

	}
	
	/**
	 * 변수 값 교환 (swap)
	 */
	public void method5c() {
		System.out.println("입력 1 2 : ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(a > b) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		for(int i=a ; i<=b ; i++) System.out.println(i);
	}
	
	/**
	 * 1부터 100 사이  7배수 개수 세기
	 */
	public void method6() {
		int count = 0;
		for (int i=1; i<=100 ; i++) if(i%7 == 0) count++;
		
		System.out.println(count);
	}
	
	public void method6a() {
		int count = 0;
		for (int i=7; i<=100 ; i+= 7) count++;
		
		System.out.println(count);
	}
	
	/**
	 * 1~100 사이 정수중 3의 배수 개수 + 3의 배수를 제외한 수들의 합 출력
	 * 
	 */
	public void method7() {
		int count=0, sum = 0;
		for(int i = 1 ; i<=100 ; i++) {
			if(i % 3 == 0) count++;
			else sum += i;
		}
		System.out.println(count);
		System.out.println(sum);
	}
	
	/**
	 *  구구단 5단 출력
	 */
	public void method8() {
		for(int i=1 ; i<=9 ; i++) {
			System.out.printf("5 * %d = %2d \n", i, 5*i );
		}
	}
	
}
