package edu.kh.collection.pack2.model.dto;

import java.util.Objects;

public class Person {
	private String name;
	private int age;
	private char gender;
	
	public Person() {	}

	public Person(String name, int age, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
	// 객체가 같다(동일, 동등) 비교
	
	
	/*
	 *  동일 비교 : hashCode() 메서드를 오버라이딩 (동일 : 가르키고 있는 것이 같다)
	 * 
	 * hash 함수 : 값을 넣으면 같은 길이의 문자열이 반환되는 함수 
	 * ㄴ ex) 123 -> qwerty / abcdefghi -> asdfgh (암호화에 많이 사용)
	 * 
	 * hashCode() : 객체별 식별 코드(객체를 구분하는 정수 값) 반환
	 * (비슷한 예 : 주민등록번호, 학번, 은행 번호표)
	 * */
	
	@Override // 오버라이딩 검사
	public int hashCode() {
		// 필드에 저장된 값을 이용해서 hashcode 생성
//		return name.hashCode() + age * 31 + gender * 31; // 31: 가장 계산이 빠른 소수
		
		// Objects : Objext 관련 유용한 기능 모음
		return Objects.hash(name, age, gender);
	}
	
	// 동등 비교 : equals() 메서드 오버라이딩 (동등 : 값이 같음)
	@Override
	public boolean equals(Object obj) {
		// 현재 객체의 필드와 전달 받은 obj의 필드가 모두 같을 경우 true, 아니면 false
		
		if(obj == null) return false; // null 비교 불가
		
		if(obj == this) return true; // 전달 받아온 주소와 현재 받아온 값이 같아 비교 불가 (비교 대상이 현재 객체)
		 
		// 같은 타입이 아니면 비교 불가
		if(!(obj instanceof Person)) return false; // obj가 참조하는 객체가 Person이 아닐 경우
		
		//다운캐스팅
		Person other = (Person)obj;
		

		return name.equals(other.name) && age == other.age && gender == other.gender;
	}
	
	
	
	
}
