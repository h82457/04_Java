package edu.kh.oopy.basic;

/**
 * 계좌 클래스
 */
public class Account {

//	 [캡슐화]
//	- 객체의 속성(필드) 직접 접근을 제한하는것이 원칙 (현재 객체만 접근 가능)
//	- 직접 접근을 제한하기 위해 모든 필드에 private 키워드 작성
//	- 속성에 직접 접근 X <- 간접 접근을 할수 있는 기능 작성 필요
	
	
	// 속성
	private String name;
	private String accountNum;
	private long balance;
	private String passwd;
	
	// * 매개 변수 : 전달 받아온 값을 저장하는 변수 *
	
	// name 변수에 값을 세팅하는 간접 접근 기능
	public void setName(String inputName) {
		
		// 매개 변수 String inputName <- String 타입의 데이터를 전달 받아 저장할 변수
		
		name = inputName; // 매개변수로 전달받아온 inputName을 name 에 저장
		
	}
	// name 변수의 값을 돌려 보내주는 간접 접근 기능
//	반환할 값이 있을 경우 void 대신 그 자리에 값의 자료형을 작성(반환형)
	public String getName() {
		return name; // >Void< methods cannot return a value (void: 반환할 값 X)
	}
	
//	* this : 현재 객체
	
	// accountNum 값 세팅하는 간접 접근 기능
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum; // 매개변수로 전달받아온 accountNum을 (this)필드의 accoutNum에 저장
	}
	
	// accountNum 값을 반환하는 간접 접근 기능
	public String getAccountNum() {
		return accountNum;
	}
	
	// passwd 값 세팅하는 간접 접근 기능 
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	//  balance 값을 반환하는 간접 접근 기능
	public long getBalance() {
		return balance;
	}
	
	/**
	 * 전달 받은 금액을 balance에 누적, 현재 잔액을 콘솔에 출력
	 */
	public void deposit(long amount) { // 매개변수로 입금 금액을 받아옴
		
		balance += amount;
		System.out.println(name + "의 현재 잔액 : " + balance);
	}
	/**
	 * 비밀번호와 출금할 금액을 전달 받아와 조건에 맞으면 잔액에서 차감후 현재 잔액을 출력
	 * 
	 * 조건 1) 비밀번호가 일치하지 않으면 "비밀번호 불일치" 출력
	 * 조건 2) 출금 금액이 잔액보다 크면 "잔액 부족" 츨력
	 * 
	 * @param pw : 전달된 비밀번호
	 * @param ammount : 출금할 금액
	 */
	public void withdraw(String pw, long amount) {
		
//		 자바 기본 자료형 비교 : == 
//		 객체(참조형) 비교 : A.equals(B)
		
		// 현재 계좌 비밀번호(passwd)와 전달받은 비밀번호(pw)가 같을 경우 true / 다르면 false
		if(!passwd.equals(pw)) { // !를 붙여 false 일경우의 조건문
			
			System.out.println("비밀번호 불일치");
			return; // 메서드 종료, 호출한곳으로 돌아감
			
		}
		
		// 출금할 금액이 잔액보다 큰 경우
		if(amount > balance) {
			System.out.println("잔액 부족");
			return;
		}
		// 잔액을 출금 금액만큼 차감
		balance -= amount;
		
		System.out.printf("%s 계좌에서 %d원 출금\n", accountNum, amount);
		System.out.println(name + "의 현재 잔액 : " + balance);
		
	}
}
