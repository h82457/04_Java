package edu.kh.poly.pack3.model.dto;

public class Washer implements Machine{
	
	// 인터페이스의 추상 메서드를 오버라이딩
	@Override
	public void powerOn() {
		System.out.println("세탁기의 터치식 전원 버튼을 누름");
	}

	@Override
	public void powerOff() {
		System.out.println("세탁기가 켜져 있을때 다시 전원 버튼을 누름");
	}
}
