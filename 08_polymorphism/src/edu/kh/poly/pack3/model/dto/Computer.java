package edu.kh.poly.pack3.model.dto;

// ㅇ 클래스, 추상 클래스 상속 키워드 : extends ~
// ㅇ interface 상속 키워드 : implements ~

public class Computer implements Machine{
	
	// 인터페이스의 추상 메서드를 오버라이딩
	@Override
	public void powerOn() {
		System.out.println("컴퓨터의 power 버튼을 눌러서 킨다.");
	}

	@Override
	public void powerOff() {
		System.out.println("컴퓨터의 시스템 종료 기능을 수행한다.");
	}
}
