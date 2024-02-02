package edu.kh.oop.field.pack3;

public class Korean {
	/* field */
	
	// static이 붙은 필드는 프로그램 실행시 static 메모리 영역에 할당
	
	/* static 필드 앞에 public을 작성 이유
	 * ㄴ 어디서든지 누구든 공유할 수 있도록 하는게 목적 */
	public static int nationalCode = 82;
	
	// static + final - final 시 대문자 사용
	public static final String ANCESTOR = "단군 할아버지";
	
	private String name;
	private String id;
	
	// 초기화 블럭 : 객체 생성시 필드를 {} 내부의 값으로 초기화
	{
		name = "김길동";
		id = "981122-1234567";
	}
	// static 초기화 블럭 - static 붙어있는 구문은 프로그램 실행시 1회만 읽음
//						ㄴ Korean 객체가 여러번 생성되어도 처음 1회만 읽음
	static {
		nationalCode=10;
	}
	
	/* 메서드 */
	public void setName(String name) {
		this.name = name;
		
		// 매개 변수로 전달 받은 name을 현재 객체의 name 필드에 대입
	}
	
	public void setid(String id) {
		this.id = id;
	}
	
	public String getName() { // 반환형 void : 반환값 X ~> 반환형 String : 반환값 String
		return name;
	}
	public String getId() {
		return id;
	}
}
