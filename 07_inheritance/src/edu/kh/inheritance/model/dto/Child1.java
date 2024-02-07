package edu.kh.inheritance.model.dto;

//	 상속 : 부모의 코드를 물려 받아 자식이 자신의 것처럼 사용
//	 상속 키워드 : extends - 부모 코드를 자식이 물려 받아 자식의 전체 크기가 증가(확장됨)

public class Child1 extends Parent{
	
	// 필드
	private String computer;
	

	public Child1() {
		
		/* super() : super 생성자 / 부모 생성자 */
//			ㄴ> 자식 객체 생성 시 부모 생성자를 호출하는 생성자
//			ㄴ> super() 생성자는 항상 자식 생성자 >첫번째 줄<에 작성
		
		super(); // == Parent에 있는 기본 생성자
		
		System.out.println("Child1 기본 생성자로 생성");
	}
	
	// 매개 변수 생성자 (computer)
	public Child1(String computer) {
		
		super("김", "경기도 부천시", 3000, "티코"); // super(~ ~ ~) 부모의 매개 변수 생성자로 연결
		
		this.computer = computer;
		System.out.println("Child1 매개 변수 생성자로 생성");
	}
	
	// 기본 생성자 (computer)
	public String getComputer() {
		return computer;
	}
	public void setComputer(String computer) {
		this.computer = computer;
	}
	
	// Child1 의 필드 + 물려받은 필드 문자열로 만들어 반환
	public String informChild1() {
	return String.format("%s / %s / %d / %s / %s", lastName, address, getMoney(), getCar(), computer); // private 은 getter/setter형태로 호출 가능
	}
	
	// 부모로부터 상속 받은 introduce 메서드 overriding(재정의) 하기
	public String introduce() {
		return "Child1 입니다.";
	}
	
	// Object -> Parent 오버라이딩한 toString() 을 또 오버라이딩 (계속해서 재정의 가능)
	@Override
	public String toString() { return super.toString() + "\nChild.toString() : " + computer;}
	
	/* final 메서드 -> 오버라이딩 불가 */
//	메서드의 기능이 안되는 경우
	
	public final void onlyChild1() {
		System.out.println("final 메서드입니다.");
	}
	}