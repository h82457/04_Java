package edu.kh.poly.pack1.model.service;

import edu.kh.poly.pack1.model.dto.Galaxy;
import edu.kh.poly.pack1.model.dto.Iphone;
import edu.kh.poly.pack1.model.dto.SmartPhone;

public class PolyService {
	/* 다형성 : 다양한 형태를 지니는 성질
	 * 
	 *  1. 상속 관계의 자식 객체의 모습이 여러 모습으로 보임
	 *  	-> 자식객체, 부모객체, Object 객체 등으로 변하는 것처럼 보인다.
	 *  
	 *  2. 오버로딩: 같은 클래스에서 같은 이름의 메서드를 여러번 작성할 수 있는 기술
	 *  	ㄴ조건: 메서드명 동일, 매개변수 개수, 타입, 순서 하나라도 달라야 함
	 *  	ㄴ목적 전달 받은 매개변수에 따른 상황별 처리 방법을 구현
	 *  
	 *  
	 * 오버로딩 예시)
	 * sum(a,b)    -> 두 수 더하기
	 * sum(a,b,c,) -> 세 수 더하기
	 * sum(배열)   -> 배열 내 요소 모두 더하기
	 * sum(배열, 배열) -> 두 배열 요소 모두 더하기
	 *  
	 *  	=> 이름은 sum 하나 인데 상황에 따라 처리하는 코드가 변하는 것 처럼 보임 (이것도 다형성!)
	 *  */
	
	/**
	 * 다형성 확인1
	 * 
	 * 부모타입 참조변수 = 자식객체;
	 * 자식객체 => 부모객체 (Up Casting, 업케스팅)
	 * 
	 * + 메모리 구조 꼭 같이 확인
	 */
	public void method1() {
		
//		SmartPhone = Iphone / Galaxy <- 원래는 컴퓨터 값 처리 원칙 위배 (자동 형변환 대상 X)

//		ㄴ> 자식 객채 내부에 존재하는 부모타입 smartPhone의 객체만 참조
//		ㄴ> 자식 객체의 모습이 부모 객체로 변한것처럼 보인다.
//			(자식 객체가 부모 객체의 모습도 가지고 있음 == 다형성)
		
		SmartPhone s1 = new Iphone();
		SmartPhone s2 = new Galaxy();
		
		// 상속 받은 부모 기능 호출 -> 가능
		s1.setDisplay("레티나 디스플레이");
		s2.setDisplay("AMOLED");
		
		System.out.println("s1.display : " + s1.getDisplay());
		System.out.println("s2.display : " + s2.getDisplay());
		
		
		// 자식 기능 호출 -> 불가능
//		s1.setIosVersion(17); // 오류
//		s2.setAndroidVersion(15); // 오류
		
//		오류 문구: The method setAndroidVersion(int) is undefined for the type SmartPhone
//			ㄴ> SmartPhone에 setIosVersion()이 정의되지 않음(==없다)
	}

	/**
	 * 다형성 확인 2
	 * (자식 타입) 부모 타입 참조 변수 -> Down Castimd 다운캐스팅
	 * 
	 * - 업캐스팅된 객체(자식-> 부모)를 참조하던 부모타입 참조 변수를
	 * 자식 타입으로 강제형변환, 다시 자식 객체를 참조하도록 변경(부모 -> 자식)
	 *  
	 */
	public void method2() {
		// 업케스팅 상태 (앞이 부모타입, 뒤가 자식타입 형식)
		SmartPhone s1 = new Iphone();
		SmartPhone s2 = new Galaxy();
		
		// 다운캐스팅 전 : 자식의 기능에 접근 불가 (참조 변수가 부모 타입이라 부모 객체의 기능만! 접근 가능)
//		int v1 = s1.getIosVersion(); // 오류
//		int v2 = s1.getAndroidVersion(); // 오류
		
		// 다운 캐스팅 후	// int v1 = (Iphone)s1.getIosVersion(); <~ 연산자 우선순위에 따라 오류 ("()" > ".")
		int v1 = ((Iphone)s1).getIosVersion();
		int v2 = ((Galaxy)s2).getAndroidVersion();
		
		// 다운 캐스팅 + 얕은 복사 (주소만 복사)
		Iphone i1 = (Iphone)s1; //  s1을 Iphone으로 강제 형변환 + i1에 주소 대입
		Galaxy g1 = (Galaxy)s2;
		
		// 자식 객체 메서드 참조 코드 작성이 간편해짐
		i1.setIosVersion(20);
		g1.setAndroidVersion(30);
		
		System.out.println("i1.iosVersion : " + i1.getIosVersion());
		System.out.println("g1.AndroidVersion : " + g1.getAndroidVersion());
	}
	
	/**
	 *  다형성 확인3		<정적 바인딩>
	 * 
	 * >프로그램 실행 전< 컴파일 단계에서 호출되는 메서드가 어떤 클래스의 메서드와 연결되는 지 결정하는것
	 */
	public void method3() {
		SmartPhone s1 = new SmartPhone();
		
		s1.setAp("M1");
//		SetAp <- void edu.kh.poly.pack1.model.dto.SmartPhone.setAp(String ap)
//			ㄴ SmartPhone 클래스의 SetAp() 메서드와 연결
		
		Galaxy g1 = new Galaxy();
		
		g1.setAndroidVersion(20);
//			ㄴ Galaxy 클래스의 setAndroidVersion()메서드와 연결
	}
	
	/** 
	 * 	다형성 확인4		<동적 바인딩>
	 * 
	 *  >프로그램 실행 중< 호출되는 메서드를 참조하는 객체의 오버라이딩 된 메서드로 연결
	 * 
	 * 부모 타입의 참조 변수 = 자식 객체 (업캐스팅)
	 * 
	 * -> 부모 타입이 참조하는 객체 == 실제로는 자식 타입 객체
	 * 	ㄴ>오버라이딩 된 메서드 호출 시 실제 참조하고 있는 자식 타입 객체의 메서드가 우선
	 * (오버라이딩 됨 == 같은 이름의 메서드가 2개 ~> 부모, 자식이 서로 같은 이름의 메서드를 가짐)
	 */
	public void method4() {
		// 업캐스팅
		SmartPhone s1 = new Galaxy("AMOLED","KT", "스냅드래곤", 17);
		
		// s1.toString() 작성시 SmartPhone의 toString() 호출된다고 표시됨 <- 정적 바인딩
		// 	(ㄴ 참조변수가 부모타입, 부모 부분의 메서드 호출)
		
		// 실행시
		System.out.println(s1.toString());
		// 결과 : SmartPhone.toString()이 아닌  Galaxy.toString() 메서드가 호출됨 == 동적 바인딩
	}
	
	/**
	 * 객체 배열 + 다형성(업캐스팅) + 다형성(동적바인딩)
	 */
	public void method5() {
		
		// 부모 타입 참조 변수로 이루어진 객체 배열 생성
		SmartPhone[] arr = new SmartPhone[3];
		
		// 배열 각 요소(SmartPhone 참조 변수)에 SmartPhone(부모), Iphone(자식), Galaxy(자식) 객체 생성+ 주소 대입
		// 부모 참조 변수 = 부모 객체 (<-다형성X)
		arr[0] = new SmartPhone("LCD","KT", "엑시노스");
		
		// 부모 참조 변수 = 자식 객체 (업캐스팅)
		arr[1] = new Iphone("Retina Display","sk", "M2 Chip", 15);
		
		// 부모 참조 변수 = 자식 객체 (업캐스팅)
		arr[2] = new Galaxy("AMOLED","LG", "스냅드래곤3", 14);
		
//		 ^ㄴ 객체 배열의 다형성을 적용 -> 배열 하나로 다양한 자료형을 묶음으로 다룰 수 있게됨
//		-> 변수 생성 코드 감소 + 반복문으로 한번에 제어 가능 => 전반적으로 코드 길이 감소
		
		
		// 반복문으로 객체 배열 순차 접근 (향상된 for문 + 업캐스팅 + 동적 바인딩)
		for(SmartPhone s : arr) { // [1],[2] 인덱스에서 업캐스팅 적용
			// 매 반복시 마다 arr의 요소를 하나씩 꺼내 s에 저장
			System.out.println( s.toString() );
			
			// [0] : SmartPhone.toString() 호출
			// [1] : Iphone.toString() 호출 (동적 바인딩)
			// [2] : Galaxy.toString() 호출 (동적 바인딩)
		}
	}
	/**
	 * 매개 변수에 다형성 적용 (오버로딩과 관련됨)
	 */
	public void method6() {
		
		// 다형성 미적용 상태
		SmartPhone smartPhone = new SmartPhone("LCD","KT", "엑시노스");
		Iphone iphone = new Iphone("Retina Display","sk", "M2 Chip", 15);
		Galaxy galaxy = new Galaxy("AMOLED","LG", "스냅드래곤3", 14);
		
		printToString(smartPhone);
		printToString(iphone);
		printToString(galaxy);
	}

	public void printToString(SmartPhone s) { // 부모만 적어져있으나 실제로는 Iphone, Galaxy 객체도 매개변수로 들어간다.
		// 매개 변수가 부모 타입 (업캐스팅 적용)
		System.out.println("[전달 받은 객체의 toString() 출력]");
		
		// 실제 참조하는 객체가 자식 객체면 자식 객체의 오버라이딩된 toString(); 호출 (동적 바인딩)
		System.out.println(s.toString());
	}
	
	// V 아래 구문들 생략 가능 V
	
//	// printToString() 오버로딩	
//	public void printToString(Iphone i) {
//		System.out.println("[전달 받은 객체의 toString() 출력]");
//		System.out.println(i.toString());
//	}
//	// printToString() 오버로딩	
//	public void printToString(Galaxy g) {
//		System.out.println("[전달 받은 객체의 toString() 출력]");
//		System.out.println(g.toString());
//	}
	
	/**
	 * 다형성 확인 7 : 반환형에 다형성 (업캐스팅) 적용
	 */
	public void method7() {
		
		printToString(createPhone(1)); // createPhone에 값 1 반환 -> if 문 실행, new SmartPhone() 으로 생성된 객체 주소
		printToString(createPhone(2)); // new Iphone() 으로 생성된 객체 주소
		printToString(createPhone(3)); 
	}
	
	// 매개 변수 값에 따라 phone 객체 생성
	// 1. SmartPhone / 2. Iphone / 3. Galaxy
	public SmartPhone createPhone(int num) { // 부모타입
		
		if(num == 1) return new SmartPhone();
		
		// 자식타입, 오류X <- 반환형에 업캐스팅 적용
		if(num == 2) return new Iphone();
		return new Galaxy();
	}
	
	/**
	 * <instanceof 연산자>	참조변수 instanceof 클래스명
	 * ㄴ>참조 변수 참조하는 객체(instance)가 지정된 "클래스"로 만들어진 객체가 맞아? (true / false 반환)
	 * 
	 * 	+ 상속 검사 용도로 사용
	 */
	public void method8() {
		
		// instanceof 연산자 연습
		SmartPhone s1 = new SmartPhone();
		
		System.out.print("s1 instanceof SmartPhone : ");
		System.out.println(s1 instanceof SmartPhone); // true
		
		System.out.println("s1 instanceof PolyService : error");
		// System.out.println(s1 instanceof PolyService); <- 상속 관계 X, instanceof 검사 불가
		
		System.out.print("s1 instanceof Iphone : ");
		System.out.println(s1 instanceof Iphone); // false
//		 ㄴ> SmartPhone과 Iphone은 상속관계가 맞으나,
//		s1이 참조하는 객체가 Iphone 클래스로 만들어진 객체인지를 물어보는것이기 떄문에 결과로 false 반환
		
		System.out.println("-----");
		
		SmartPhone s2 = new Iphone();
		
		System.out.print("s2 instanceof SmartPhone : ");
		System.out.println(s2 instanceof SmartPhone); // true
		
		System.out.print("s2 instanceof Iphone : ");
		System.out.println(s2 instanceof Iphone); // true
	}
	
	/**
	 * 객체 배열 + 업 캐스팅 + 다운 캐스팅 + instanceof
	 */
	public void method9() {
		
		// 부모 타입 객체 배열 생성 - SmartPhone 참조 변수 3칸짜리 배열 생성
		SmartPhone[] arr = new SmartPhone[3];
		
		// 부모 타입 객체 배열 = 요소 별로 부모 /자식 객체 초기화
//													(업 캐스팅)
//		 + 메서드 반환형에 다형성(업 캐스팅) 적용
		for(int i=0 ; i<arr.length ; i++) { // 순차 접근
			
			arr[i] = createPhone(i + 1); // 1-> new SmartPhone(); / 2-> new Iphone(); ...호출
//			arr[0] = createPhone(1) == new SmartPhone() <- 업 캐스팅 (arr의 자료형은 SmartPhone 이기떄문)
		}
		
		// 향상된 for 문 + instanceof + 다운 캐스팅
		for(SmartPhone s : arr) {
			
			// s가 탐조하고 있는 객체가 Iphone 객체?
			if(s instanceof Iphone) {
				((Iphone)s).setIosVersion(999); // 다운 캐스팅 후 자식클래스에만 있는 버젼 사용 가능 
			}
			
			// s 가 참조하고 있는 객체가 Galaxyl 객체?
			else if(s instanceof Galaxy){
				((Galaxy)s).setAndroidVersion(333);
			}
			else { // Iphon도 Galaxy도 아닌 경우 == SmartPhone
				s.setDisplay("부모 화면"); //자식이 아닌 본 클래스의 객체이므로 다운캐스팅 필요 X
			}
		}
		
		// 향상된 for 문 + 매개 변수 다형성(업 캐스팅) + 동적 바인딩
		for(SmartPhone s : arr) printToString(s);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
