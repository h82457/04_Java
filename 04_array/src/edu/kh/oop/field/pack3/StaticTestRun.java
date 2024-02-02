package edu.kh.oop.field.pack3;

public class StaticTestRun {
	public static void main(String[] args) {
		
		// Korean 객체 생성
		Korean k1 = new Korean();
		Korean k2 = new Korean();
		
		System.out.println("k1의 nationalCode : " + k1.nationalCode);
		System.out.println("k1의 nationalCode : " + k2.nationalCode);
		
		// k1 을 이용해서 nationalCode 변경
		k1.nationalCode = 1;
		
		System.out.println("--- nationalCode 변경 후 ---");
		
		System.out.println("k1의 nationalCode : " + k1.nationalCode);
		System.out.println("k1의 nationalCode : " + k2.nationalCode);
		
		
//		The static field Korean.nationalCode should be accessed in a static way
//		ㄴ static 필드는 static 방법으로 접근 필요
//		k1.nationalCode 와같은 객체의 필드명/메서드명이 아닌 static 영역에 할당된 이름으로 호출 필요
//		(객체의 독립된 필드로 인식될 수 있기 떄문에 햇갈리지 않도록 정해져있는 이름으로만 부르는게 좋다.)
		
		System.out.println("korean.natinalCode: " + Korean.nationalCode);
		
		System.out.println("우리의 조상님 : " + Korean.ANCESTOR);
		
//		 static final 대표적 예시
//		 ㄴ Math.PI
//		 ㄴ integer.MAX_VALUE / Integer.MIN_VALUE
		
		System.out.println(Math.PI);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	}
}
