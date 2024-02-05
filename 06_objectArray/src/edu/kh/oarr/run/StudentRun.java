// 탭 배치 순서 : Run - View - Service - DTO

package edu.kh.oarr.run;

import edu.kh.oarr.view.Studentview;

// 자바 프로그램 실행용 클래스
public class StudentRun {
	public static void main(String[] args) {
		
		// 처음 실행시 View 객체의 displayMenu() 메서드 호출
		new Studentview().displayMenu();
	}
	
}
