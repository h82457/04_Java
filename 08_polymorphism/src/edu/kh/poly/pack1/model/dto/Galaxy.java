package edu.kh.poly.pack1.model.dto;

public class Galaxy extends SmartPhone {

	private int androidVersion; // 안드로이드 운영체제 버전
	
	// 기본 생성자
	public Galaxy() {}
	
//	 매개변수 생성자 + super() 매개 변수 생성자 자동 완성 단축키
//	 	ㄴ alt [+shift] + s -> o -> 드롭다운에서 부모 선택 -> generate
	
	// 매개변수 생성자 (부모클래스의 생성자 + 현재 클래스의 생성자)
	public Galaxy(String display, String newsAgency, String ap, int androidVersion) {
		
		// 부모 클래스의 매개 변수 생성자로 연결
		super(display, newsAgency, ap);
		
		this.androidVersion = androidVersion;
	}
	
	// toString() 
	@Override
	public String toString() {
		return "Galaxt AndroidVersion : " + androidVersion + " / " + super.toString();
	}

	// getter / setter
	public int getAndroidVersion() { // 단축키) alt [+shift] + s -> r
		return androidVersion;
	}

	public void setAndroidVersion(int androidVersion) {
		this.androidVersion = androidVersion;
	}

	

	
	
}
