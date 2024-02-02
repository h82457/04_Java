package edu.kh.oop.field.pack1;

public class FieldRun1 {
	public static void main(String[] args) {
		
		// FieldTest1 객체 생성
		FieldTest1 f1 = new FieldTest1();
		
		System.out.println(f1.publicValue);
		System.out.println(f1.protectedValue);
		System.out.println(f1.defaultValue);
		
		// private 접근 불가 <- 클래스가 상이
//		System.out.println(f1.privateValue);

	}
	
	
	
}
