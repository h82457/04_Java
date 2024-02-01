package edu.kh.oopy.basic;

public class BasicRun {
	public static void main(String[] args) {
		
		// 국민 객체 생성
		// == 국민(Nation) 클래스의 내용대로 Heap 영역에 할당
		Nation n1 = new Nation();
		
		n1.name = "홍길동";
		n1.age = 34;
		n1.gender  = '남';
		
		// 점, 하위 접근 연산자 (.) - 객체의 속성/기능을 접근, 호출, 실행 시키는 연산자
		
		System.out.printf("이름은 %s 이고, %d세 %c성 입니다.\n", n1.name, n1.age, n1.gender);
//		System.out.println("객체 생성 확인");
		
		// Nation 객체 참조 변수 n2에 Heap 영역에 Nation 클래스를 이용해 생성된 객체의 주소를 대입
		Nation n2 = new Nation();
		
		n2.name = "신짱구";
		n2.age = 5;
		n2.gender = '남';

		n2.introduce(); // 짱구 자기소개
		
		Nation n3 = new Nation();
		n3.name = "봉미선";
		n3.age = 29;
		n3.gender = '여';
		
		n3.introduce(); // 봉미선 자기소개
		
		// 납세의 의무 확인
		n1.납세의의무();
		n2.납세의의무();
		n3.납세의의무();
		
		
	}
}
