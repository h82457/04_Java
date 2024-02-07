package edu.kh.poly.pack1.model.dto;

public class Iphone extends SmartPhone {
	
	private int iosVersion;
	
	// 기본 생성자
	public Iphone() {}

	// 매개 변수 생성자
	public Iphone(String display, String newsAgency, String ap, int iosVersion) {
		super(display, newsAgency, ap);
		this.iosVersion = iosVersion;
	}

	// getter / setter
	public int getIosVersion() {
		return iosVersion;
	}
	
	public void setIosVersion(int iosVersion) {
		this.iosVersion = iosVersion;
	}

	// toString()
	@Override
	public String toString() {
		return "iosVersion : " + iosVersion + " / " + super.toString();
	}
}



