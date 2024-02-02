package edu.kh.oop.basic;

// 클래스 : 객체가 가져야할 속성(값), 기능(메서드)를 글(코드)로 작성해둔 문서(설계도)
/**
 * 국민 객체를 만들기 위한 클래스 작성
 */
public class Nation {
	/* 속성(값) */
	String name;
	int age;
	char gender;
	String juminNumver;
	String tel;
	String adress;
	
	/* 기능 */
	public void spaekKorean() {
		System.out.println("한국어 가능");
	}

	public void welfare() {
		System.out.println("복지를 누릴수 있음");
	}
	
	public void 납세의의무() {
		// 만 19세 이상 성인만 세금을 내는 경우
		if(age >= 19) System.out.printf("%s 님은 세금 납부 대상자입니다.\n", name);
		else System.out.printf("%s 님은 %d세 미성년자로 납부 대상자가 아닙니다.\n", name, age);
//		System.out.println("세금.... 내야지 ... 내돈 ㅠㅠ");
	}
	
	/**
	 * 자기 소개 기능
	 */
	public void introduce() {
		System.out.printf("이름은 %s 이고, %d세 %c성 입니다.\n", name, age, gender);
	}
}
