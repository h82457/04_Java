package edu.kh.oop.constructor;
/* 	오버로딩 (Over Loading)
 * 
 * - 한 클래스 내에 동일한 이름의 메서드를 여러개 작성하는 기법
 * - 같은 이름의 메서드가 수행하는 기능은 기본적으로 같으나,
 * 			전달 받은 매개변수에 따라서 조금씩 동작이 달라야하는 경우를 상황별로 정의
 * 
 * - 오버로딩의 조건
 * 1) 메서드 이름 동일해야한다.
 * 2) 매개 변수는 개수, 타입, 순서가 하나라도 달라야한다.
 * */

public class Member {

	
//	필드 (== 멤버 변수)
//	- 클래스 변수 : static이 붙은 변수 <- static 메모리에 할당시 클래스명.변수명으로 할당
//	- 인스턴스 변수 : static이 없는 변수 <- 인스턴스(객체)가 생성될 때 heap 메모리에 할당
	
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
	
//	생성자 : 객체 생성시 필드 초기화 + 특정 기능 수행 메서드
//	작성 규칙 : 1) 반환형 X		2) 생성자 이름은 클래스명과 동일
	
	// -----------------	

	/* 기본 생성자 */
//		ㄴ매개 변수가 없는 형태, 생성자가 하나도 작성되지 않은 경우 컴파일러가 자동으로 추가 
	public Member() {
		
		// 생성시 수행할 기능
		System.out.println("[기본] 생성자로 Member 객체 생성됨");
		
		// 생성시 객체 초기화
		memberId = "ID를 입력해 주세요";
		memberPw = "Pw를 입력해 주세요";
		memberName = "이름을 입력해 주세요";
	} 
	// -----------------	

	/* 매개 변수 생성자 */
//		ㄴ 객체 생성시 매개변수로 전달된 값을 생성된 객체의 필드에 초기화하는 용도의 생성자
	
//	 Duplicate method Member() in type Member <- 중복되는 메서드 오류, 매개변수 입력시 사라짐
	public Member(String memberId, String memberPw, String memberName, int memberAge) { 
		
		System.out.println("[매개 변수] 생성자로 객체 생성됨");
		
//		this. == 생성되고 있는 객체
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberAge = memberAge;
	}
	
	// -----------------	

	/* 오버로딩을 이용해서 생성자 만들기 */
	// 매개변수 갯수가 다름
	public Member(String memberId) { 
		this.memberId = memberId;
	}
	
	public Member(String memberId, String memberPw) {
		this.memberId = memberId;
		this.memberPw = memberPw;
	}
	
	
	//매개변수 타입이 다름
	public Member(int memberAge) {
		this.memberAge = memberAge;
	}
	
	public Member(String memberId, int memberAge) {
		this.memberId = memberId;
		this.memberAge = memberAge;
	}
	
	
	// 매개 변수 순서가 다름
	public Member(int memberAge, String memberId) {
		this.memberAge = memberAge;
		this.memberId = memberId;
	}
	
//	public Member(int memberAge, String memberPw) {}
//	  ㄴ> [Duplicate method Member(int, String) in type Member] 오류
//		ㄴ> 오버로딩은 >변수명이 아닌< 자료형의 개수, 순서, 타입 중 하나라도 달라야 성립!
	
	// -----------------
	
	
	/* this() 생성자 */
//	현재 클래스에 있는 다른 생성자를 호출 -> 코드 중복 감소 (길이 감소)
	public Member(int memberAge, String memberId, String memberPw) {
		
//		this.memberAge = memberAge;
//		this.memberId = memberId;

		this(memberAge, memberId); // <-this() 사용으로 위의 구문이(89~99) 한줄로 짧아짐
		
		this.memberPw = memberPw;
	}
	
	
	// -----------------	
	// 기능(메서드)
	// setter : 전달 받은 매개 변수를 현재 객체의 필드에 대입
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}
	
	// getter : 현재 객체의 필드를 외부에서 얻어갈 수 있게 반환
	public String getMemberId() {
		return memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public int getMemberAge() {
		return memberAge;
	}

	// -----------------	

	/**
	 * 현재 객체의 필드 값을 한번에 출력
	 */
	public void inform() {
		System.out.println("\n------");
		System.out.println("memberId : " + memberId);
		System.out.println("memberPw : " + memberPw);
		System.out.println("memberName : " + memberName);
		System.out.println("memberAge : " + memberAge);
		System.out.println("------\n");
		
		

	}
	
}
