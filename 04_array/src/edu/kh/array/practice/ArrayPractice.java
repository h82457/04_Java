package edu.kh.array.practice;

import java.util.Arrays;
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
			System.out.print(arr[i] + " ");
			
		}
		
		
	}
	
	public void practice4(){
		int[] arr = new int[5];
		
		for(int i=0 ; i<arr.length ; i++) {
			
			// 정수 5개를 입력 받아 배열을 초기화
			System.out.printf("입력 %d : ", i);
			arr[i] = sc.nextInt();
		}
		
		// 검색할 정수를 하나 입력 받아 배열에서 같은 수가 있는 인덱스를 찾아 출력.
		System.out.print("검색할 값 : ");
		int searchValue = sc.nextInt();
		
		for(int i=0 ; i<arr.length ; i++) {
			
			if(arr[i] == searchValue) {
				System.out.println("인덱스 : " + i);
				return;
			}
			System.out.println("일치하는 값이 존재하지 않습니다");
		}
	}
	
	public void practice5(){
		System.out.print("정수 : ");
		int len = sc.nextInt();
		
		int[] arr = new int[len];
		
		for(int i=0 ; i<arr.length ; i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
			arr[i] = sc.nextInt();
		}
		
		int sum=0;
		
		for(int i=0 ; i<arr.length ; i++) {
			System.out.print(arr[i]+ " ");
			sum += arr[i];
		}
	}
	
	public void practice6(){
		
		// 주민등록번호를 입력 받아 char 배열에 저장한 후 출력
		char[] arr = new char[14];
		System.out.print("주민등록번호(-포함) : ");
		String input = sc.next();
		
		// 문자열.length() : 문자열이 길이를 반환 메서드 / 배열.length : 배열 길이 반환 필드
		for(int i=0, len = input.length() ; i<len ; i++) {
			// 성별 부분 전까지는 그대로 배열에 대입
			if(i<=7) arr[i] = input.charAt(i);
			
			// 성별 부분 이후 모두 * 대입
			else arr[i] = '*';
		}
		// 배열에 담긴 내용 모두 출력
		for(int i=0 ; i<arr.length ; i++) System.out.println(arr[i]);
	}


	public void practice7(){
		
		// 3이상인 홀수를 입력 받기

		int len = 0;
		
		while(true) { // 3이상인 홀수를 입력까지 무한 반복
			System.out.print("정수 : ");
			len = sc.nextInt();
			
			// 입력 받은 정수가 3 이상의 홀수인 경우 반복 종료
			if(len >= 3 && len % 2 == 1) break;
			
			// 입력한 정수가 홀수가 아니거나 3 미만일 경우 “다시 입력하세요”를 출력
			System.out.println("다시 입력하세요.");
		}
		// 입력 받은 정수 크기 만큼의 배열 선언, 할당
		int[] arr = new int[len];
		int count = 0; // arr 배열 요소에 대입
		
		for(int i=0 ; i<len ; i++) {
			
			if(i <= len / 2) count++; // 배열 길이 절반 이하인경우 증가
			else count--;			  // 배열 길이 절반 이상인경우 감소
			
			arr[i] = count;
		}
		
		// Arrays.toString(배열명) : 배열 내 요소를 "[1,2,3]" 형식의 문자열로 만들어 반환
		System.out.println(Arrays.toString(arr));
	}
	
	public void practice8(){
		
		// 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당
		int[] randoms = new int[10];
		
		String str = "";
		
		for(int i=0 ; i<randoms.length ; i++) {
			
			randoms[i] = (int)(Math.random() * 10 +1);
			
			str += randoms[i] + " ";
		}
		System.out.println("발생한 난수 : " + str);
	}
	
	public void practice9(){
		
		// 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당
		int[] randoms = new int[10];
		
		String str = "";
		int max = 0;
		int min = 0;

		for(int i=0 ; i<randoms.length ; i++) {
			
			randoms[i] = (int)(Math.random() * 10 +1);
			
			str += randoms[i] + " ";
			
			// 배열 전체 값과 그 값 중에서 최대값과 최소값을 출력
			if(i == 0) { // 첫 반복인 경우
				max = randoms[i];
				min = randoms[i];
				continue; // 다음 반복으로 이동
			}
			
			// 첫 반복이 아닌 경우 
			if(randoms[i] > max) max = randoms[i];
			if(randoms[i] < min) min = randoms[i];
		}
		System.out.println("발생한 난수 : " + str);
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
	}
	
	public void practice10(){
		// 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당
		int[] randoms = new int[10];
		String str = "";
		
		// 1~10 사이의 난수를 발생시켜 중복된 값이 없게 배열에 초기화한 후 출력
		
		// 난수 생성
		for(int i=0 ; i<randoms.length ; i++) {
			randoms[i] = (int)(Math.random() * 10 +1);
			
			// * 증복 검사 방법 * : 현재 인덱스에 대입된 난수와 같은 값이 앞쪽 인덱스에 존재하면
			//  다시 현재 인덱스에 새로운 난수를 생성해서 대입 (중복이 없을떄까지 반복)
			
			// 현재 인덱스 앞쪽까지만 순차 접근
			for(int x=0 ; x<i ; x++) {
				if(randoms[i] == randoms[x]) { // 현재 인덱스에 저장된 값과 앞쪽 인덱스에 저장된 값이 같을 경우 중복 판단
					i--; // 바깥쪽 for의 i 증가를 막아서 현재 인덱스번째 요소에 다시 새로운 난수를 대입
					break;
				}
			}
		}

		for(int i=0 ; i<randoms.length ; i++) {
			str += randoms[i] + " ";
			
		}	
	}
	public void practice11(){
		
		// 1. 크기가 6인 정수형 배열 생성
		int[] lotto = new int[6];
		
		// 2. 1~45 사이 중복 없는 난수로 lotto 배열 요소 초기화
		for(int i=0; i<lotto.length ; i++) {
			lotto[i] = (int)(Math.random() * 45 +1);
			
			for(int x=0; x<i ; x++) {
				if(lotto[i] == lotto[x]) {
					i--;
					break;
				}
			}
		}
		Arrays.sort(lotto); // 자바에서 만들어서 제공해주는 배열 오름차순 정렬 기능
		System.out.println(Arrays.toString(lotto));
	}
	
	public void practice12() {
		System.out.print("문자열 : ");
		String str = sc.next(); 
		
		
		for(int i=0 ; i<str.length() ; i++) {
			
			// 문자열에 어떤 문자가 들어갔는지 배열에 저장
			
			
		}
		
		
		
		
	}
}