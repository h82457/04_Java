package edu.kh.io.pack3.model.dto;

import java.io.Serializable;

// 직렬화 (Serializable) : 객체를 직선형태로 변경 
// 직렬화 방법 => Serializable 인터페이스를 상속 받아온다.

/* Serializable 인터페이스 */
// - 추상 메서드가 하나도 없는 인터페이스 <- 오버라이딩 필요X
// - 상속만 받아도 입/출력시 직렬화 가능하다는 의미만 제공
// 	   ㄴ> 마커 인터페이스 

public class Member implements Serializable{

//	 serialVersionUID : 직렬화 식별 번호
//	  ㄴ> 직렬화/역직렬화시 같은 객체가 맞는지 확인하는 식별 번호 미작성시 JVM이 알아서 지정
	
	private String id;
	private String pw;
	private String name;
	private int age;
	
	// 기본 생성자 ( 객체 생성시 필드 초기화+기능 수행_
	public Member() {}

	// 매개 변수 생성자
	public Member(String id, String pw, String name, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
	}
	
	// getter / setter - 필드 간접 접근 방법)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	// Object.toString() 오버라이딩(재정의)
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", age=" + age + "]";
	}
}
