package edu.kh.inheritance.run;

import edu.kh.inheritance.model.dto.Child1;
import edu.kh.inheritance.model.dto.Parent;
import edu.kh.inheritance.model.dto2.Child2;

public class TestRun {

	public static void main(String[] args) {
		
		// 부모 객체 Parent 생성
		
		Parent p1 = new Parent(); // 기본 생성자
		Parent p2 = new Parent("김", "서울시 어딘가", 2000, "G80");
		
		System.out.println("-------------------------------------");
		Child1 c1 = new Child1(); // 자식1 기본 생성자
		
		
		// Child1  자식의 기능
		c1.setComputer("삼성 갤럭시북4");
		
		// Child1 내부에 생성된 Parent의 기능
		String str1 = c1.inform();
		System.out.println("str1 : " + str1);
		
		// Child1 자식의 기능
		String str2 = c1.informChild1();
		System.out.println("str2 : " + str2);
		
		
		System.out.println("----------------------------------");
		
		// Child1 매개 변수 생성자를 이용해서 객체 생성
		Child1 c2 = new Child1("2024 LG GRAM");
		String str3 = c2.informChild1();
		
		System.out.println("str3 : " + str3);
		
		
		System.out.println("----------------------------------");
		
		// Child2 객체 생성 (매개 변수 생성자 이용)
		Child2 c3 
			= new Child2("최", "서울시 강남구", 999_999_999, "벤츠", "아이폰15");
		
		String str4 = c3.informChild2();
		System.out.println("str4 : " + str4);
		
		
		System.out.println("======================================");
		System.out.println("======================================");
		System.out.println("======================================");
		
		
		System.out.println("\n[상속을 이용해서 공통된 규약 설정하기]\n");
		// Parent - Child1
		//				ㄴChild2
		
		// Parent를 상속 받은 Child1/2는 서로 비슷한 모양을 띄게 된다
		// (같은 부모를 상속 받았으니까)
		
		// Parent에 코드를 추가하면 어떻게될까?
		
		Child1 ch1 = new Child1();
		Child2 ch2 = new Child2();
		
		ch1.testMethod();
		ch2.testMethod();
		// 부모에 코드 추가/수정하면 모든 자식한테도 코드가 추가/수정 된다!!!
		
		
		// 오버라이딩 확인하기
		System.out.println("----- 오버라이딩 -----");
		System.out.println(ch1.introduce());
		System.out.println(ch2.introduce());
		
		
		System.out.println("----- toString() 오버라이딩() -----");
		
		System.out.println(p1.toString());
		System.out.println(ch1.toString());
		System.out.println(ch2.toString());
		
		
		// 오버라이딩 전
//		edu.kh.inheritance.model.dto.Parent@67b64c45
//		edu.kh.inheritance.model.dto.Child1@4411d970
//		edu.kh.inheritance.model.dto2.Child2@6442b0a6
		
		// Parent 오버라이딩
		// -> 오버라이딩된 Parent의 toString()을 Child1/2가 상속 받음
		
//		Parent.toString() : 홍 / 서울시 중구 남대문로 120 / 100000000 / 그랜져
//		Parent.toString() : 홍 / 서울시 중구 남대문로 120 / 100000000 / 그랜져
//		Parent.toString() : 홍 / 서울시 중구 남대문로 120 / 100000000 / 그랜져
		
		
	}
	
	
	
	
	
	
	
}
