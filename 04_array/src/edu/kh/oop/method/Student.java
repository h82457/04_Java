package edu.kh.oop.method;

public class Student {
	
	// 필드
	public static String schoolName = "KH대학교";
	
	public static final int MIN_VALUE = 0;   // 스킬 역량 최소
	public static final int MAX_VALUE = 100; // 스킬 역량 최대
	
	private String name;					// 이름
	private String studentNum; // 학번
	private char gender;				  // 성별
	private int java;							// 자바 역량
	private int html;							// html 역량
	
	// 생성자
	public Student() {} // 기본 생성자
	
	// 매개 변수 생성자 (오버로딩)
	public Student(String name, String studentNum, char gender) {
		this.name = name;
		this.studentNum = studentNum;
		this.gender = gender;
	}
	
	
	// 메서드
	
	// setter
	public void setName(String name) {
		this.name = name;
	}
	
	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public void setJava(int java) {
		this.java = java;
	}

	public void setHtml(int html) {
		this.html = html;
	}
	
	
	// getter
	public String getName() {
		return name;
	}
	
	public String getStudentNum() {
		return studentNum;
	}
	
	public char getGender() {
		return gender;
	}
	
	public int getJava() {
		return java;
	}
	
	public int getHtml() {
		return html;
	}
	
}
