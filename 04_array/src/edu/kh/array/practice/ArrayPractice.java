package edu.kh.array.practice;

import java.util.Scanner;

public class ArrayPractice {

	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		int[] arr = new int[9];
		int sum = 0;
		
		for(int i=0; i<arr.length ; i++) {
			arr[i] = i+1;
			System.out.printf("%s ", arr[i]);
			
			if(i % 2 == 0) sum += arr[i];

		}
		System.out.println("\n짝수 번째 인덱스 합 : " + sum);
	}
	
	public void practice2(){} {
		int[] arr = new int[9];
		int sum = 0;
		for(int i=arr.length-1 ; i>=0 ; i--) {
			arr[i] = i+1;
			System.out.printf("%s ", arr[i]);
			
			if(i % 2 == 1) sum += arr[i];
		}
		System.out.println("\n홀수 번째 인덱스 합 : " + sum);
	}
	
	public void practice3(){
		// 사용자에게 입력 받은 양의 정수만큼 배열 크기를 할당
		
		System.out.println("양의 정수 : ");
		int input = sc.nextInt();
		
		int[] arr = new int[input];
		
		// 1부터 입력 받은 값까지 배열에 초기화한 후 출력
		for(int i=0 ; i<input ; i++) {
			arr[i] = i+1;
			System.out.printf("%s " , arr[i]);
			
		}
		
		
	}
	
//	public void practice4(){
//		int[] arr = new int[5];
//		
//		for(int i=0 ; i<arr.length ; i++) {
//			
//			// 정수 5개를 입력 받아 배열을 초기화
//			System.out.print("입력 i : ");
//			arr[i] = sc.nextInt();
//		}
//		
//		// 검색할 정수를 하나 입력 받아 배열에서 같은 수가 있는 인덱스를 찾아 출력.
//		System.out.print("검색할 값 : ");
//		int input = sc.nextInt();
//
//	}
}
