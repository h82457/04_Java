package edu.kh.collection.pack2.model.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import edu.kh.collection.pack2.model.dto.Person;

public class SetService {
	/* - Set
	 * 	ㄴ 기본적으로 순서 유지 X (인덱스(x) -> get (x))]
	 * 	ㄴ 중복 데이터 저장 X <- 같은 데이터가 들어오면 덮어쓰기
	 * 	
	 * - Set 인터페이스의 자식 클래스
	 * 	1) HashSet (대표) : 처리 속도가 빠른 Set
	 * 	2) linkedHashSet : 순서를 유지하는 Set
	 * 	3) TreeSet : 자동 정렬되는 Set
	 * 	*/
	
	/**
	 * HashSet 사용법
	 * 	- 사용 조건 1 : 객체에 equals() 가 오버라이딩 되어 있어야 함
	 * 	- 사용 조건 2 : 객체에 hashCode() 가 오버라이딩 되어 있어야 함
	 * 
	 * 		=> String, Integer 등 자바에서 제공하는 객체는 모두 오버라이딩 되어있는 상태
	 */
	public void method1() {
		
		// HashSet 객체 생성
//		Set<String> set = new LinkedHashSet<String>(); // LinkedHashSet <- 순서유지
		Set<String> set = new HashSet<String>(); // 다형성 업케스팅
		
		// 1. boolean add(E e) : 추가
		set.add("네이버");
		set.add("카카오");
		set.add("라인");
		set.add("쿠팡");
		set.add("배달의민족");
		set.add("당근마켓");
		set.add("토스");
		set.add("직방");
		set.add("야놀자");
		
		System.out.println(set.toString()); // set.toString()
//		~> HashSet 순서 유지X  확인
		
		// 중복 저장 확인 => 불가
		set.add("배달의민족");
		set.add("배달의민족");
		set.add("배달의민족");
		set.add("배달의민족");
		set.add("배달의민족");
		
		// null도 중복X 확인 (null <- 참조하는 객체가 없음)
		set.add(null);
		set.add(null);
		set.add(null);
		set.add(null);
		set.add(null);
		
		System.out.println(set);
//		~> null 1회 출력
		
		// 2. int size() : Set에 저장된 객체(참조변수)의 수 반환
		System.out.println("set.size() : " + set.size());
		
		// 3. boolean remove(E e) : 전달 받은 e를 Set에서 제거 - 제거 성공 true, 없으면 false
		System.out.println(set.remove("배달의민족"));
		System.out.println(set.remove("유풀러스"));
		System.out.println(set);
		
		// 4. boolean contains(E e) : 전달 받은 e가 Set에 존재시 true, 없다면 false
		System.out.println("쿠팡 있는지 확인 : " + set.contains("쿠팡"));
		System.out.println("삼성 있는지 확인 : " + set.contains("삼성"));
		
		// 5. void clear() : Set에 저장된 내용 모두 삭제
		set.clear();
		
		// 6. boolean is Empty() : 비어있으면 true, 아니면 false
		System.out.println("비어있음? : " + set.isEmpty());
	}
	
	/**
	 * Set 에 저장된 요소(객체) 를 꺼내는 방법
	 *  ㄴ 1) Iterator (반복자) 이용
	 *  ㄴ 2) List로 변환
	 *  ㄴ 3) 향상된 for 문 이용 <- *
	 */
	public void method2() {
		
		 Set<String> set = new HashSet<String>();
		 
		 set.add("몽쉘");
		 set.add("꼬북칩");
		 set.add("쿠쿠다스");
		 set.add("빈츠");
		 set.add("포카칩");
		 
		 // 1. Iterator(반복자) - 컬렉션 객체에 저장된 요소를 하나씩 순차 접근 하는 객체
		 // set.iterator() : 현재 Set을 순차 접근할 수 있는 Iterator 객체 반환
		 Iterator<String> it = set.iterator(); // set의 자료형에 맞춰 String으로 지정
		 
		 // boolean Iterator.hasNext() : 다음 순차 접근할 요소가 있으면 true, 없으면 true
		 while(it.hasNext()) { // 다음 요소가 있으면 반복, 없으면 멈춤
			 
			 // E Iterator.next() : 다음 요소를 꺼내와 반환
			 String temp = it.next();
			 System.out.println(temp);
		 }
		 
		 System.out.println("--------------");
		 System.out.println("[List로 변환]");
		 
		 // set에 저장된 객체를 이용해서 List 생성
		 List<String> list = new ArrayList<String>(set); // 자동완성 Array중 collection  선택
		 
		 // 일반 for 문
		 for(int i=0 ; i < list.size() ; i++) {
			 System.out.println(list.get(i));
		 }
		 
		 System.out.println("--------------");
		 System.out.println("[향상된 for문]");		 
		 
		 for(String snack : set) System.out.println(snack);
	}
	
	/**
	 * 직접 만든 클래스(Person)를 이용해 만든 객체를 Set에 저장 (중복 제거 확인)
	 */
	/**
	 * 
	 */
	public void method3() {	
		Person p1 = new Person("홍길동", 25, '남');
		Person p2 = new Person("홍길동", 25, '남');
		Person p3 = new Person("홍길동", 30, '남');
		Person p4 = new Person("김길순", 20, '여');
		
		
		// hashCode() : 객체 식별 번호(정수), 같은 필드 값을 가진 객체는 번호가 같다! (중복된 필드로 저장시 하나만 저장되기때문)
		System.out.println("p1 : " + p1.hashCode()); // 498677820
		System.out.println("p2 : " + p2.hashCode()); // 498677820
		System.out.println("p3 : " + p3.hashCode());
		System.out.println("p4 : " + p4.hashCode());
		
		// A.equals(B) : A와 B가 가지고 있는 필드 값이 같다면 true
		System.out.println("p1.equals(p2) : " + p1.equals(p2));
		System.out.println("p1.equals(p3) : " + p1.equals(p3));
		
		// Set 중복 제거 확인
		Set<Person> personSet = new HashSet<Person>();
		personSet.add(p1);
		personSet.add(p2);
		personSet.add(p3);
		personSet.add(p4);
		
		System.out.println("------------------");
		for(Person p : personSet) System.out.println(p); // 25세 홍길동이 한번만 출력, 중복 제거
		
		// ************
		// Hash 라는 단어가 포함된 컬렉션 이용시 HashCode(), equals() 오버라이딩 필수 진행!
		// ************
	}
	
	/**
	 * TreeSet : 이진 트리 구조를 이용해 객체를 저장하는 Set
	 * 	-> 기본 오름차순 정렬
	 *  ** 전제조건 : 저장되는 객체는 Comparable 인터페이스 상속 필수!
	 */
	public void method4() {
		
		// 난수 생성 
		// 1) Math.random()
		// 2) Random.nextInt()
		
		Random random = new Random();
		
		// Integer(객체, Wrapper Class) <==> int(기본자료형)
		Set<Integer> lotto = new TreeSet<Integer>();
		
		while(lotto.size() < 6) { // lotto에 저장된 값이 6개 미만이면 반복 == 6개면 멈춤
			lotto.add(random.nextInt(45) +1);
		}
		
		System.out.println(lotto);
	}
	
	/**
	 * 로또 번호 생성기
	 * 금액을 입력 받아 (천원 단위)
	 * 1000원 당 1회씩 번호를 생성해서 List에 저장한 후 생성 종료시 한번의 출력
	 * 
	 * <pre>
	 * 금액 입력 : 3000
	 * 
	 * 1회 : [11,22,33,44,55]
	 * 2회 : [1,2,3,4,5]
	 * 3회 : [10,20,30,40,50]
	 * </pre>
	 * 
	 */
	public void lottoNumberGenerator() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("금액 입력(천원 단위) : ");
		int input = sc.nextInt();

		
		Random random = new Random();
		
		
		// 생성된 로또 번호를 저장할 List
		List<Set<Integer>> lottoList = new ArrayList<Set<Integer>>(); // Integer만 저장하는 Set List		
		
		for(int i=0, end = input / 1000 ; i < end ; i++) {

			Set<Integer> lotto = new TreeSet<Integer>(); 
			
			while(lotto.size() < 6) lotto.add(random.nextInt(45) +1);
			
			lottoList.add(lotto); // 반복시마다 List 각 인덱스에 서로 다른 Set 참조 주소 저장
		}
		
		// 출력용 반복문
		for(int i=0, size = lottoList.size() ; i < size ; i++) {
			
			System.out.println((i+1) + "회 : " + lottoList.get(i));
		}
	}
}
