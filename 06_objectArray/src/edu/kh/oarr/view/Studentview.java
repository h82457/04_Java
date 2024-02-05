package edu.kh.oarr.view;

import java.util.Scanner;

import edu.kh.oarr.model.dto.Student;
import edu.kh.oarr.model.service.StudentService;

// 입/출력 담당 클래스 (객체의 속성, 기능 정의)
public class Studentview {
	// 필드 (객체의 속성, 멤버 변수)
	// static 이 붙은 필드 == 클래스 변수
	// static이 없는 필드 인스턴스 변수
	
	private Scanner sc = new Scanner(System.in);
	
	// StudentService 클래스 가져오기
	private StudentService service = new StudentService();
	
	/**
	 * 메뉴 표시 기능
	 */
	public void displayMenu() {
		
		int input = 0; // 메뉴 번호를 입력 받을 변수
		
		do {
			System.out.println("\n----- 학생 관리 프로그램 -----");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 1명 정보 조회(인덱스)");
			System.out.println("4. 학생 이름으로 조회"); // 동명이인 X
			System.out.println("5. 학생 정보 수정(인덱스)");
			System.out.println("6. 학생 1명 점수 조회(점수, 합계, 평균)");
			System.out.println("7. 평균 최고점, 최저점 학생");
			System.out.println("0. 종료");
			
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			
			switch(input) {
			case 1: addStudent(); break;
			case 2: selectAll(); break;
			case 3: selectIndex(); break;
			case 4: selectName(); break;
			case 5: updateStudent(); break;
			case 6: selectScore(); break;
			case 7: selectMaxMin();break;
			case 0: System.out.println("[프로그램 종료]"); break;
			default : System.out.println("[잘못 입력]");
			}
			
			
		}while(input != 0);
	}
	
	/** 1)
	 * 학생 추가 화면
	 * 
	 * 학번, 이름, 성별을 입력 받아 StudentService의 students 배열에 추가
	 */
	private void addStudent() {
		
		System.out.println("\n -----  학생 추가 -----");
		
		// 학번, 이름, 성별을 입력 받기
		
		System.out.print("학번 : ");
		String studentNum = sc.next();
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("성별(M/F) : ");
		char gender = sc.next().toUpperCase().charAt(0); // 문자열.toUpperCase() : 영어 대문자로 변경
		
		// 학생 추가 Service 메서드 호출 후 결과 반환 받기
//		매개변수 (studentNum, name, gender) 를 가지는 Student 객체를 생성해서 service의  addStudent 메서드 호출,
//		계산된 값을 boolean result에 대입
		boolean result = service.addStudent(new Student(studentNum, name, gender));
		
		
		if(result) System.out.println(name + "학생이 추가 되었습니다.");
		else System.out.println("학생을 더이상 추가할 수 없습니다.");
	}
	
	/** 2)
	 * 등록된 학생 전체 출력
	 */
	private void selectAll() {
		
		System.out.println("\n ----- 학생 전체 조회 -----");
		
		// Service 에 있는 students 배열 참조 주소를 반환 받아 / studentList 배열에 저장
		Student[] studentList = service.getStudents();
		
		for(int i=0 ; i<studentList.length ; i++) {
			
			// 학생이 없는 인덱스인 경우 반복 종료
			if(studentList[i] == null) break;
			
			// 학생이 있는 인덱스인 경우 내용 출력 (student클래스의 toString 메소드 이용)
			System.out.println(i + "번째 인덱스\n" + studentList[i].toString());
			System.out.println();
		}
		
	}
	
	/** 3)
	 * 학생 1명의 정보 조회 (index 검색)
	 */
	private void selectIndex() {
		
		System.out.println("\n ----- 학생 1명 정보 조회(인덱스) -----");
		
		// 조회할 인덱스 값 받기
		System.out.print("인덱스 입력: ");
		int index = sc.nextInt();

		// Service의 selectIndex 메소드로 Index값 전달, 인덱스값이 일치하는 학생이 있다면 반환 받아 std에 저장
		Student std = service.selectIndex(index);
		
		if(std == null) System.out.println("해당 인덱스에 학생이 존재하지 않습니다.");
		else {
			System.out.println("학번 : " + std.getStudentNum());
			
			String temp = null;
			if(std.getGender() == 'F') temp = "여성";
			else temp = "남성";
			
			System.out.println("성별 : " + temp);
			
			System.out.println("이름 : " + std.getName());
			
			System.out.println("----- 점수 -----");
			System.out.println("HTML : " + std.getHtml());
			System.out.println("CSS : " + std.getCss());
			System.out.println("JS : " + std.getJs());
			System.out.println("Java : " + std.getJava());
		}
	}

	private void selectName() {
		System.out.println("\n----- 학생 이름으로 조회 -----");
		
		System.out.print("이름 입력 : ");
		String name = sc.next();
		
		Student std = service.selectName(name);
		
		if(std == null) System.out.println("같은 이름의 학생이 존재하지 않습니다.");
		else {
			System.out.println("학번 : " + std.getStudentNum());
			
			String temp = null;
			if(std.getGender() == 'F') temp = "여성";
			else temp = "남성";
			
			System.out.println("성별 : " + temp);
			
			System.out.println("이름 : " + std.getName());
			
			System.out.println("----- 점수 -----");
			System.out.println("HTML : " + std.getHtml());
			System.out.println("CSS : " + std.getCss());
			System.out.println("JS : " + std.getJs());
			System.out.println("Java : " + std.getJava());
		}
	}
	
	/**
	 * 인덱스를 먼저 입력 받아 해당 인덱스에 학생이 존재하면
	 * HTML, CSS, Js, Java 점수를 입력 받아 해당 학생에게 세팅(set)
	 */
	private void updateStudent() {
		System.out.println("\n----- 학생 정보 수정(인덱스) -----");
		
		System.out.print("수정할 학생의 인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		Student std = service.selectIndex(index);
		
		if(std == null) {
			System.out.println("해당 인덱스에 학생이 존재하지 않습니다.");
			return;
		}
		
		// HTML, CSS, Js, Java 점수를 입력 받아 std에 세팅
		System.out.print("HTML, CSS, Js, Java 순서로 입력 : ");
		std.setHtml(sc.nextInt());
		std.setCss(sc.nextInt());
		std.setJs(sc.nextInt());
		std.setJava(sc.nextInt());
		
		System.out.println("수정 완료");
	}
	
	/** 학생 점수 조회(각각의 점수, 합계, 평균)
	 * 
	 * 1) 인덱스를 입력 받아 해당 학생 존재 확인
	 * 2) 있을경우 service.selectScore(인덱스) 호출 -> 형태의 문자열로 반환 받아와서 출력
	 * 
	 *	  HTML(50) CSS(80) JS(100) Java(30)
	 *    합계 : 280
	 *    평균 : 70.0
	 */
	private void selectScore() {
		System.out.println("----- 학생 1명 점수 조회(점수, 합계, 평균) -----");
		
		System.out.println("조회할 학생의 인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		Student std = service.selectIndex(index);
		
		if(std == null) {
			System.out.println("해당 인덱스에 학생이 존재하지 않습니다.");
			return;
		}
		
		String result = service.selectScore(index);
		
		System.out.println(result);
	}
	
	/**
	 * 평균 최고점 최저점 학생 조회하기
	 */
	private void selectMaxMin() {
		System.out.println("----- 평균 최고점, 최저점 학생 -----");
		
		String result = service.selectMaxMin();
		
		System.out.println(result);
	}
}
