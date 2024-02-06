package edu.kh.inheritance.run;

import edu.kh.inheritance.model.dto.Child1;
import edu.kh.inheritance.model.dto.Parent;
import edu.kh.inheritance.model.dto2.Child2;

public class TestRun {
	public static void main(String[] args) {
		
		// 부모 객체 Parent 생성
		Parent  p1 = new Parent(); // 기본 생성자
		
		Parent p2 = new Parent("김", "서울시 어딘가", 2000, "G80"); // 매개 변수 생성자
		
		System.out.println("---------");
		
		// 부모 객체 실행 -> 자식 객체 실행
		Child1 c1 = new Child1(); // 자식1 기본 생성자
		
		// Child1 자식의 기능
		c1.setComputer("삼성 갤럭시북4");
		
		// Child1 내부에 생성된 Parent 기능
		String str1 = c1.inform(); // inform <-Parent 에서 작성
		
		System.out.println("str1 : " + str1);
	
		// Child1 자식의 기능
		String str2 = c1.informChild1();
		
		// 
		System.out.println("str2 : " + str2);
		
		
		System.out.println("---------");

		// Child1 매개 변수 생성자를 이용해서 객체 생성
		Child1 c2 = new Child1("2024 LG GRAM");
		
		String str3 = c2.informChild1();
		System.out.println("str3 : " + str3);
		
		
		System.out.println("---------");
		
		// Child2 객체 생성 ( 매개 변수 생성자 이용)
		Child2 c3 = new Child2("최", "서울시 강남구", 99999, "벤츠", "아이폰15");
		
		String str4 = c3.informChild2();
		System.out.println("str4 : " + str4);
		
		
		System.out.println("=========");
		System.out.println("=========");
		
		System.out.println("\n[상속을 이용해서 공통된 규약 설정하기]\n");
//		parent 	- Child1
//				ㄴ Child2   ...Parent를 상속 받은 Child1/2는 서로 비슷한 모양을 띄게 된다.
		
		Child1 ch1 = new Child1();
		Child2 ch2 = new Child2();
		
		
		// 부모에 코드를 추가/수정하면 모든 자식한테도 코드가 추가/수정 된다.
		ch1.testMethod();
		ch2.testMethod();
		
		// overriding 확인 
		System.out.println("----- overriding -----");
		System.out.println(ch1.introduce()); // 재정의 된 내용 출력
//		System.out.println(ch2.introduce()); // 재정의X ~> 부모의 코드 그대로 출력
		System.out.println(ch2.introduce()); // 재정의 된 내용 출력
		
		System.out.println("----- toString() overriding() -----");
		
//		// 오버라이딩X => 클래스명 + 6진수 형태로 출력
//		System.out.println(p1.toString());
//		System.out.println(ch1.toString());
//		System.out.println(ch1.toString());
		
		// Parent 오버라이딩 => 오버라이딩 된 Parent의 toString()을 Child1/2가 상속 받음
		System.out.println(p1.toString());
		System.out.println(ch1.toString());
		System.out.println(ch1.toString());
		
		
		
		}
	
		
	
	
}
