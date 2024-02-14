package edu.kh.exception.pack3.model.exception;

/**
 * 100 초과 예외 
 * - RuntimeException 상속
 * -> UnChecked Exception
 * -> 예외 처리 구문 작성 필수 X
 * 
 * - 사용자 정의 예외는 RuntimeException 상속 받는 경우 많음
 */

public class MoreThanAHundredException extends RuntimeException{

	public MoreThanAHundredException() {
		super("100을 초과 하였습니다");
	}
	
	public MoreThanAHundredException(String message) {
		super(message);
	}
}
