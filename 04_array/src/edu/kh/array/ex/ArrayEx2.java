package edu.kh.array.ex;

import java.util.Arrays;

public class ArrayEx2 {
	/**
	 *  얕은 복사 : 주소만 복사, 값 변경시 원본도 같이 변경
	 */
	public void method1() {
		
		int[] arr1 = {100,200,300,400};
		
		int[] arr2 = arr1;
		
		System.out.println("arr1: "+ Arrays.toString(arr1));
		System.out.println("arr2: "+ Arrays.toString(arr2));
		
		// 서로 다른 변수를 이용해서 값 변경
		arr1[0] = 1234;
		arr2[1] = 9876;
		
		System.out.println("---");
		
		// 얕은 복사(같은 주소 참조) 상태이기 때문에 arr1, arr2 모두  출력시 같은 결과
		System.out.println("arr1 : " + Arrays.toString(arr1));
		System.out.println("arr2 : " + Arrays.toString(arr2));
	}
	/**
	 * 깊은 복사 : 값을 똑같이 복사한 배열/객체 생성
	 */
	public void method2() {
		int[] arr1 = {10,20,30,40,50}; // 원본 배열
		
		// 값을 복사할 배열 (깊은 복사)
		int[] arr2 = new int[arr1.length];
		int[] arr3 = new int[arr1.length];
		
		// 깊은 복사 방법 1 : for 이용
		for(int i=0 ; i<arr1.length ; i++) {
			arr2[i] = arr1[i];
		}
		
		// 깊은 복사 방법 2 : System.arraycopy() 이용 
		System.arraycopy(arr1, 0, arr3, 0, arr1.length);
		
		
		System.out.println("arr1 : " + Arrays.toString(arr1)); // 원본
		System.out.println("arr2 : " + Arrays.toString(arr2)); // for		
		System.out.println("arr3 : " + Arrays.toString(arr3)); // arraycopy
		
		// 모든 배열의 0번 인덱스 값을 변경
		arr1[0] = 999;
		arr2[0] = 888;
		arr3[0] = 777;
		
		System.out.println("===================================");
		System.out.println("arr1 : " + Arrays.toString(arr1)); // 원본
		System.out.println("arr2 : " + Arrays.toString(arr2)); // for		
		System.out.println("arr3 : " + Arrays.toString(arr3)); // arraycopy
	}
	
	/**
	 * 2차원 배열 : 1차원 배열 참조 변수의 묶음
	 */
	public void method3() {
		
		// 2차원 배열 선언
		int [][] arr = new int[2][3]; // == 3칸짜리 1차원 배열 참조변수 2개를 묶은 배열
		
		// 2차원 배열 초기화
		arr[0][0] = 10;
		arr[0][1] = 20;
		arr[0][2] = 30;
		arr[1][0] = 40;
		arr[1][1] = 50;
		arr[1][2] = 60;
		
		// 2차원 배열 내 모든 요소 순차적 접근
		
		// arr.length == 행의 개수 (1차원 배열 참조 변수의 개수)
		for(int row = 0 ; row < arr.length ; row++) {
			
			// arr[row].length == 열의 개수 (arr[row] 이 참조하는 1차원 배열의 길이)
			for(int col=0 ; col < arr[row].length ; col++) {
				
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
	
	}
}
