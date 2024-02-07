package edu.kh.inheritance.model.dto;

// 상속 계층 구조

// Object
//  ㄴParent
//   ㄴChild1
//    ㄴGrandChild1

public class GrandChild1 extends Child1{

	// final 메서드 확인(오버라이딩 불가)
	
	/*
	@Override
	public void onlyChild1() {} // 에러
	// Cannot override the final method from Child1
	// -> 재정의 불가
	*/
	
	
}
