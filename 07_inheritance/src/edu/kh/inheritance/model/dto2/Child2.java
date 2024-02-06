package edu.kh.inheritance.model.dto2;

import edu.kh.inheritance.model.dto.Parent;



public class Child2 extends Parent { // 상속 받으려는 부모 클래스가 다른 패키지에 존재-> import 필요
	
	private String smartPhone;
	
	// 기본 생성자
	public Child2() {
//		super(); <~ 생성자 미작성시 컴파일러가 자동으로 추가
		
		System.out.println("Child2 기본 생성자");
	}
	
	
	// 매개 변수 생성자(부모 필드 + 자식 필드)
	public Child2(String lastName, String address, int money, String car, String smartPhone) {
		
//		 전달 받은 매개 변수 5개중 4개는 Child2 내부에 생성된 Parent에 초기화 되어야 하는 값
//		ㄴ> vv parent의 매개변수 생성자 호출 필요 vv
		
		super(lastName, address, money, car);
		
		this.smartPhone = smartPhone;
		
		System.out.println("child2 매개 변수 생성자로 객체 생성");
	}

	
	// 기본 생성자
	public String getSmartPhone() {
		return smartPhone;
	}

	public void setSmartPhone(String smartPhone) {
		this.smartPhone = smartPhone;
	}
	
	
	public String informChild2() {
		
//		return String.format("%s / %s / %d / %s / %s", lastName, address, getMoney(), getCar(), smartPhone);
		return inform() + " / " + smartPhone;
//		ㄴ> 부모 메소드 inform + 자식 필드 내용 (중복되는 코드를 제거해서 코드 길이를 감소 시킴 == 코드 재사용성 증가)
	}
	
	// 부모로부터 상속 받은 introduce() 메서드
	// overriding 하기 + @Override 통한 검사 (<- 컴파일러가 검사) (@ == Annotation)
	
	@Override
//	public int introduce() { //  >> int << 오류 - The return type is incompatible with Parent.introduce()
//		return 0;			 // ㄴ> 반환형을 int로 입력, 부모 코드와 달라 오류 발생
//	}
	
	public String introduce() { 
//	return "Child2 입니다. + " + introduce(); // introduce() <- 현재 자식의 메소드가 호출되어 오류
	return "Child2 입니다. + " + super.introduce(); // 오버라이딩한 메소드 + 부모 메소드 같이 이용시 앞에 super. 을 붙여 사용 가능 
//									ㄴ>(자식의 부모 객체를 가리키는 참조변수 ( this. 와 비슷한 용도의 참조변수)
	}
	
	// toString() 오버라이딩
	@Override
	public String toString() {
		return super.toString() + "\nChild2 : " + smartPhone;
	}
}
