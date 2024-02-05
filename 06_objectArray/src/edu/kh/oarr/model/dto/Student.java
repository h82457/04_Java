package edu.kh.oarr.model.dto;

// DTO : Data Transfer Object (값 전달용 객체)

public class Student {
	private String studentNum;
	private String name;
	private char gender;
	private int html;
	private int css;
	private int js;
	private int java;


	// 매개 변수 생성자
	public Student(String studentNum, String name, char gender) {
		
		this.studentNum = studentNum;
		this.name = name;
		this.gender = gender;
	}
	
	// studentNum getter/setter
	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}
	
	public String getStudentNum() {
		return studentNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getHtml() {
		return html;
	}

	public void setHtml(int html) {
		this.html = html;
	}

	public int getCss() {
		return css;
	}

	public void setCss(int css) {
		this.css = css;
	}

	public int getJs() {
		return js;
	}

	public void setJs(int js) {
		this.js = js;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}
	
	
	public String toString() { // <- 객체.toString() : 객체의 필드를 하나의 문자열로 만들어서 반환
		// 학번 / 성별 / 이름
		// HTML : 100 / CSS : 50 / JS : 70 / Java : 100
		return String.format("%s / %s / %s \n"
				+ "HTML : %d / CSS : %d / JS : %d / Java : %d", studentNum, gender, name, html, css, js, java);
	}
	
}

// getter / setter 자동 완성

// alt + [shift] + s -> r (Generated Getters and Setters ...) -> select All -> Generate