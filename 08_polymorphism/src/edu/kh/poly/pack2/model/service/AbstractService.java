package edu.kh.poly.pack2.model.service;

import edu.kh.poly.pack2.model.dto.Animal;
import edu.kh.poly.pack2.model.dto.Dog;
import edu.kh.poly.pack2.model.dto.Snake;


public class AbstractService {

	
	/**
	 * 추상 클래스 객체 생성 확인 <- 불가
	 */
	public void method1() {
		
//		Animal a = new Animal(); // 오류 : Cannot instantiate the type Animal
//		 객체화 불가, 추상클래스 Animal을 이용한 객체 생성 불가 ^ㅢ
		
	}
	
	/**
	 * 추상 클래스를 상속 받은 클래스를 이용해 객체 생성
	 * 	+ 다형성(업캐스팅, 동적 바인딩) + 객체 배열
	 */
	public void method2() {
		
		
		
//		 + 추상 클래스를 상속 받은 자식의 객체 생성은 가능!
//			-> 이때 자식 객체 내부에 존재하는 부모 객체 부분도 같이 생성
//		 * 부모의 미완성(추상) 메서드는 자식이 오버라이딩 메서드로 자동으로 동적 바인딩 된다.
		
		
		/* 추상 클래스는 객체 생성은 안되지만 부모 타입의 참조 변수 역할은 할 수 있다.*/
//			-> 동적 바인딩으로 인해 자식 객체내 부모 추상 메서드 호출 불가 (컴파일 오류 발생
		
//		Animal a1 = new Animal("포유류", false); // 오류 <- 추상클래스
		Animal a1 = new Dog("포유류", false);
		Animal a2 = new Snake("파충류", true);
		Animal a3 = new Dog("포유류", false);
		Animal a4 = new Snake("파충류", true);
		
		// 부모 타입(Animal) 객체 배열 생성
//		Animal[] arr = new Animal[4]; // 부모타입의 참조 변수로는 사용 가능
		Animal[] arr = {a1, a2, a3, a4}; // 배열 생성과 동시에 초기화 (얕은 복사)
		
		// 향상된 for 문 + 동적 바인딩
		// 	+ print 구문의 특징
		for(Animal a: arr) {
			System.out.println("-----");
			
			// 아래 구문들 모두 동적 바인딩 수행
//			System.out.println(a.toString());
//			 Object.toString() 목적 : 객체를 문자열로 표현 == 객체의 필드를 모두 모아 하나의 문자열로 반환
			
			System.out.println(a);
			
			// print() 관련된 구문에 참조 변수를 작성하면 자동으로 toString() 메서드를 호출
			
			a.eat();
			a.sleep();
		}

		
		
	}
}
