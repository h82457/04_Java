package edu.kh.collection.pack1.model.service;

import java.util.List;
import java.util.Scanner;

import edu.kh.collection.pack1.model.dto.Book;

import java.util.ArrayList;
import java.util.LinkedList;



// 컬렉션 프레임워크: Java 에서 자료구조를 만들어서 모아둔 것 (java.util에 존재)
// 특징
// 1) 크기 제한 없음 (부족하면 자동으로 증가)
// 2) 추가, 수정, 삭제, 검색 등 다양한 기능이 구현되어 있음
// 3) 객체만 저장 가능
// (기본 자료형은 안됨 / 하지만 wapper 클래스 이용시 가능)

public class ListService {

	// List : 자료를 순차적으로 나열한 자료 구조 (배열 비슷)
//	 - 인덱스가 존재 -> 인덱스로 순서가 구분되기 때문에 중복 데이터 저장 가능
	
	/**
	 * List 사용
	 */
	public void method1() {
		// List 객체 생성
//		 - List (인터페이스) -> 객체 생성 불가 -> 다형성 이용, 업캐스팅
		
		// - ArrayList (클래스) (List 의 후손)
//		List list = new ArrayList(); // <- 기본 생성시 10칸짜리 생성 
		List list = new ArrayList(3); // <- 기본 생성시 3칸짜리 생성 
		
		// 반환형 메서드명 (매개변수)
		
//		 E(Elemnet) : 요소를 뜻하는 상징적인 글자(기본형X)
//						== object, String, Sutdent 등 자료형 가리지 않고 들어갈 수 있다.
		
		// 1.  boolean add(E e) : 마지막 요소로 추가
		list.add("아무거나");
		list.add(new Object()); // 객체
		
		list.add(123123); // -> int가 Integer(Wrapper Class)로 변환 (<컴파일러)
		
		list.add(3.123123); // 크기가 3을 초과했을 때 오류 발생 X
//			ㄴ> 크기 초과시 자동으로 확장됨
		list.add(false);
		
		System.out.println(list);
		
		// 2. E get(int index) : List 에서 index 번째 요소 반환 받기
		
		// 3. int Size() : List 에 저장된 요소(객체)의 개수를 반환
		
		System.out.println("저장된 개수 : " + list.size()); // 5 <- 크기를 자동으로 배정해주기때문에 사이즈 의미 X
		
		// 0번 부터 List 에 저장된 개수 미만까지 1씩 증가하며 반복
		for(int i=0 ; i<list.size() ; i++) {
			System.out.printf("%d 번째 인덱스 : ", i);
			System.out.println(list.get(i));
			
			// List의 i번째 요소가 String 인 경우
			if(list.get(i) instanceof String) {
				System.out.println("[String 자료형 입니다.]\n");
				continue;
			}
			
			// List 의 i번쨰 요소가 int 인 경우
			if(list.get(i) instanceof Integer) { // (int< X, Integer< X>)
				// 오류 : Incompatible conditional operand types Object and int
				System.out.println("[Integer 자료형 입니다.]\n");
				continue;
			}
			
			// List의 i번쨰 요소가 double(-> Double 변환)인 경우
			if(list.get(i) instanceof Double) {
				Double d = (Double)list.get(i); // 다운 캐스팅
				// list.get(i) ==> Object 반환
				
				System.out.println("double의 바이트 크기 : " + d.BYTES + "\n");
			}
			
			// Object <- 최상위 부모클래스로 모든 타입 참조 가능 (다형성, 업캐스팅)
			Object[] test = new Object[5];
			test[0] = "아무거나";
			test[1] = 123123;
			test[2] = new Object();
			test[3] = "3.123123";
		}	
	}

	/**
	 * 컬렉션 List + 제네릭(타입 제한)
	 */
	public void method2() {
//		컬렉션의 장점  "여러 타입 저장 가능" <-  사용시 코드 길이 늘어남
//			ㄴ> 타입을 하나로 제한한 제네릭 사용, 코드 길이 감소
		
		// String 타입으로 제한된 ArrayLIst 객체 생성
		List<String> strList = new ArrayList<String>();
		
		// 제네릭 타입 제한 확인 
		strList.add("닭갈비");
		strList.add("치킨");
		strList.add("보쌈");
//		strList.add(123); // String 이 아니라서 에러
		
		strList.add("족발");
		strList.add("카레돈까스");
		strList.add("한우불고기버거");
		
		for(int i=0 ; i<strList.size(); i++) { // length(X), size(O) <- 컬렉션은 사이즈 사용
			
			String foodName = strList.get(i);
			System.out.println(foodName);
		}
		
		// 3. void add(int index, E e) : index 번쨰에 중간 삽입
		strList.add(1, "찜닭");
		
		// 4. String toString() : List 에 저장된 모든 요소 문자열로 반환
		System.out.println(strList);
//		== System.out.println(strList.toString());
		
		// 5. E Set(int index, E e) : index 번쨰 요소를 e 로 수정
//						ㄴ> 수정 전 요소가 반환
		String before = strList.set(2, "양념치킨");
		System.out.println("수정 전 : " + before);
		System.out.println("수정 후 : " + strList.get(2));
		System.out.println(strList);
		
		// int indexOf(E e) : List 내부에 e 와 같은 요소가 있으면 해당 인덱스, 없으면 -1 반환
		System.out.println(strList.indexOf("보쌈")); // 3
		System.out.println(strList.indexOf("막국수")); // -1 (같은 요소 없음)

		// 7. boolean contains(E e) : List 내부에 e 와 같은 요소가 있으면 true, 없으면 false
		System.out.println(strList.contains("보쌈")); // true
		System.out.println(strList.contains("막국수")); // false
		
		// 8. E remove(int index) : index 번쨰 요소를 제거(추출) -> 제거된 요소가 반환
		String target = strList.remove(0); // 0 번 인덱스 요소 제거
		
		System.out.println("제거된 요소 : " + target);
		System.out.println(strList);
	}
	
	/**
	 * Book으로 제한된 List 객체 생성 후
	 * 	- 추가, 조회, 수정 ,제거 구현
	 */
	public void bookManage() {
		/* - ArrayList : 배열 형태의 리스트 
		 * ㄴ 장점 : 검색이 빠름
		 * ㄴ 단점 : 중간 삽입, 제거가 느림
		 *  
		 * - LinkedList : 연결된 형태의 리스트(기차)
		 * ㄴ 장점 : 중간 삽입, 제거가 빠름
		 * ㄴ 단점 : 검색이 느림
		 * */
		
//		List<Book> bookList = new ArrayList<Book>(); // ArrayList
		List<Book> bookList = new LinkedList<Book>(); // LinkedList
		
		Scanner sc = new Scanner(System.in);
		int input = 0; // 메뉴 번호 입력
		
		do {
			System.out.println("----- 도서 관리 프로그램 ----");
			System.out.println("1. 추가");
			System.out.println("2. 전체 조회");
			System.out.println("3. index 로 조회");
			System.out.println("4. 수정");
			System.out.println("5. 제거");
			System.out.println("0. 종료");
			
			System.out.println("메뉴 번호 입력 >>>");
			input = sc.nextInt();
			sc.nextLine(); // 스캐너 버퍼에 남아있는 개행 문자 제거
			
			switch(input) {
			case 1: 
				
				System.out.println("제목 입력 : ");
				String title = sc.nextLine(); // 한줄 입력
				
				System.out.println("글쓴이 입력 : ");
				String writer = sc.nextLine();
				
				System.out.println("가격 입력 : ");
				int price = sc.nextInt();
				
				if( bookList.add( new Book(title, writer, price)  ) ) {
					System.out.println("추가 성공!!!!");
				}
				
				
				
				break;
			case 2: 
				System.out.println("\n----- 전체 조회 -----\n");
				
				// 향상된 for 문
				for(Book b : bookList) System.out.println(b); //생략시에도 toString() 출력
				break;
				
			case 3: 
				System.out.print("조회할 책의 인덱스 입력 : ");
				int index = sc.nextInt();
				
				if(index > 0 && index <bookList.size()) { // 정상
					System.out.println(bookList.get(index));
				}else {
					System.out.println("\n<<<인덱스 범위가 옳지 않습니다.>>>\n");
				}
				break;
				
			case 4: // 인덱스를 정상적으로 입력했다고 가정
				System.out.println("\n[책 수정]\n");
				System.out.println("수정할 인덱스 번호");
				index = sc.nextInt();
				sc.nextLine();
				
				System.out.println("수정할 책 제목 : ");
				title = sc.nextLine();
				
				System.out.println("수정할 책 글쓴이 : ");
				writer = sc.nextLine();

				System.out.println("수정할 책 가격 : ");
				price = sc.nextInt();

				Book after = new Book(title, writer, price);
				Book before = bookList.set(index, after);
				
				System.out.println("전 : " + before);
				System.out.println("후 : " + after);
				break;
				
			case 5: 
				System.out.println("\n[책 제거]\n");
				System.out.println("제거할 인덱스 번호");
				index = sc.nextInt();
				
				Book target = bookList.remove(index);
				System.out.println("제거된 책 : "+ target);
				
				break;
				
			case 0: System.out.println("\n[프로그램 종료]\n"); break;
			default : System.out.println("\n[잘못 입력]\n"); break;
			}
			
		}while(input != 0);
	}
}
