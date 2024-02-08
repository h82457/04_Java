package edu.kh.poly.pack3.model.dto;

public interface Machine { /* Interface : 접점(클래스간의 접점을 만드는 용도) */
	// 필드 : 상수형 필드만 작성 가능 (public static final)
	
//	public static final int VOLT = 220; 아래와 동일<- 명시적으로 작성하지 않아도 묵시적으로 인식
	int VOLT = 220; // public static finaml 구문 생략 가능
	
	// 메서드 : 추상 메서드만 작성 가능 (public abstract)
//	public abstract void powerOn(); 아래와 동일 <- public abstract 구문 생략 가능
	void powerOn();
	void powerOff(); 
	
}
