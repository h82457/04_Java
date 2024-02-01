package edu.kh.oopy.basic;

public class AccountRun {
	public static void main(String[] args) {
		
		// Account 객체 생성
		Account a1 = new Account();
		
		// private이 설정된 값과 안된 값 접근 가능 여부 확인
//		a1.accountNum = "1";
//		a1.name = "홍길동";
		
		// private을 적용한 변수(필드)는 외부에서 보이지 않음(정보 은닉)
		// The field Account.balance is not visible
//		a1.balance;
//		a1.passwd;
		
		// 간접 접근 기능을 이용해서 값을 세팅
		a1.setName("신형만");
		
		// 간접 접근 기능을 이용해서 객체의 속성을 얻어와 출력
		String name1 = a1.getName();
		System.out.println(name1);
		
		a1.setAccountNum("1234-56-7890");
		a1.setPasswd("7890");
		
		Account a2 = new Account(); // acccount 객체를 참조할 참조변수를 만들어서 참조하게함
		a2.setName("신짱아");
		a2.setAccountNum("111-222-333");
		a2.setPasswd("7777");
		
		// 각 계좌에 입금
		a1.deposit(10000000L);
		a1.deposit(2345L);
		
		a2.deposit(50000L);
		a2.deposit(30000L);
		
		
		// 각 계좌에서 출금
		System.out.println("------");

		a1.withdraw("1234", 200000); // 비밀번호 불일치
		a1.withdraw("7890", 200000); // 잔액 부족
		a1.withdraw("7890", 50000); // 출금 성공
		
		System.out.println("------");
		a2.withdraw("1234", 200000); // 비밀번호 불일치
		a2.withdraw("7777", 200000); // 잔액 부족
		a2.withdraw("7777", 50000); // 출금 성공
		
		
	}
}
