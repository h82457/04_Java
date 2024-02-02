package edu.kh.oop.method;

public class StudentRun {
	public static void main(String[] args) {
		
		// 생성된 StudentService 객체를 1회성으로 사용, 저장 X
		new StudentService().displayMenu(); 
		
		
	}
}
