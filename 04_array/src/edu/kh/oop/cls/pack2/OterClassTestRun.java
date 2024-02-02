package edu.kh.oop.cls.pack2;

import edu.kh.oop.basic.Account;
import edu.kh.oop.basic.Nation;

// ClassTest1 과 다른 패키지에 존재하는 클래스
public class OterClassTestRun {
	public static void main(String[] args) {
		
		// 1) public class 인 Nation 과 Account 클래스를 이용해서 객체 생성
		Nation n1 = new Nation();
		 
		Account a1 = new Account();
		 
		// -> 문제 없음 (import도 잘됨)
		
		// -----
		
		// 2) (default) class 인 ClassTest1 클래스를 이용해 객체 생성
//		ClassTest1 c1 = new ClassTest1(); <- 다른 패키지에 존재 - import 불가
//		(default) 접근 제한자는 다른 패키지에서 외부접근 불가
	}
}
