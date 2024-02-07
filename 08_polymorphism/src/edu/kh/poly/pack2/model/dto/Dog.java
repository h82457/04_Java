package edu.kh.poly.pack2.model.dto;

public class Dog extends Animal{
// ^ㄴ 오류: The type Dog must implement the inherited abstract method Animal.sleep()
//		ㄴ 해결: 오버라이딩
	
	// 필드
	private boolean harness;
	
	// 기본 생성자
	public Dog() {
		super();
	}
	
	// 매개 변수 생성자
	public Dog(String type, boolean harness) {
		super(type);
		this.harness = harness;
	}

	public Dog(boolean harness) {
		super();
		this.harness = harness;
	}
	
	// getter / setter
	public boolean isHarness() {
		return harness;
	}

	public void setHarness(boolean harness) {
		this.harness = harness;
	}

	
	// 추상 클래스를 상속 받은 경우 부모 클래스에 작성된 추상 메서드를 반드시 모두 오버라이딩 필요
	@Override
	public void eat() {
		System.out.println("강아지는 엎드려 입을 이용해서 밥을 먹는다.");
	}
	
	@Override
	public void sleep() {
		System.out.println("강아지는 몸을 웅크려서 잔다.");
	}
	
	@Override
	public String toString() {
		return super.toString() + " / 가슴줄 유무 : " + harness;
	}
	
}
