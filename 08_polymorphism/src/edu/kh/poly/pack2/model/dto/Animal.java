package edu.kh.poly.pack2.model.dto;

// abstract class (추상 클래스)
// - 추상 메서드를 포함하고 있는 클래스
// - 미완성인 부분을 포함하고 있기 때문에 객체로 생성하는 것이 불가

public abstract class Animal { 
	// 동물의 공통된 필드 / 메서드 작성
	private String type;
	
	// 기본 생성자
	public Animal() {}
	
	// 매개변수 생성자
	public Animal(String type) {
		this.type = type;
	}
	
	// getter / setter
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return type;
	}
	// 추상 클래스 - 코드를 정의하는 {}가 없는 메서드
//	모든 동물들이 가지고 있는 기능, 하나로 정의 내리기 어려움, 부모 클래스 Animal 에서 eat(), sleep() 정의 불가
//		ㄴ>Animal 을 상속 받는 자식 클래스에서 각자에게 맞춰 재정의(오버라이딩)하도록 강제화
	public abstract void eat();
	public abstract void sleep();
//	오류 : The abstract method sleep in type Animal can only be defined by an abstract class
//		ㄴ> 클래스 선언부에 abstract 추가시 해결
}