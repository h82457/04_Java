package edu.kh.collection.pack3.model.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import edu.kh.collection.pack2.model.dto.Person;

import java.util.Set;

public class MapService {

	/* Map : 특정 키워드(Key)를 입력하면 해당되는 상세한 값(Value)를 얻을 수 있는 컬렉션 객체
	 * 	ㄴ K:V 형식으로 구성
	 * 	ㄴ K:V 한쌍을 "Entry"라고 부름
	 *  ㄴ Key : 키워드 역할(== 변수명)
	 *  
	 *  1) 중복 X - 중복되는 Key 입력 시 Value를 덮어씌움
	 *  		  -  Key 역할의 객체는 hashCode(), equals() 오버라이딩 필수
	 *  2) 순서 유지 X ( 단, LinkedHashMap 제외)
	 *  
	 *  * Key만 묶어서 보면 Set과 같은 특징을 지님
	 *  	-> Map.keySet() / Map.EntrySet() 제공
	 *  
	 *  Value : 키워드에 해당하는 상세한 값
	 *  	ㄴ Key로 인해서 모든 Value가 구분 -> Map.get(Key) / Map.remove(key) 형태로 사용
	 * */
	
	public void method1() {
		
		// HashMap 생성
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		// 1) V put(K k, V v) : Map에 추가
//		- Map에 추가시 중복되는 Key가 없으면 null, 중복되는 Key가 있으면 Value 반환
		System.out.println(map.put(1, "에그마요"));
		System.out.println(map.put(2, "로티세리바베큐"));
		System.out.println(map.put(3, "스테이크앤치즈"));
		System.out.println(map.put(3, "스파이시쉬림프")); // Key값 중복
		
		System.out.println(map);
		
		// 2.V get(K k) : K에 해당되는 Value 반환, 일치하는 Key가 없으면 null 반환
		System.out.println("2---");
		System.out.println(map.get(1)); // 에그마요
		System.out.println(map.get(0)); // null
		
		String temp1 = map.get(2); // 로티세리바베큐
		System.out.println(temp1);
		
		// 3. int size() : Map 에 저장된 Entry(K:V)의 개수
		System.out.println("3---");
		System.out.println("size : " + map.size()); //3
		
		// 4. V remove(K k) : Key가 일치하는 Entry를 제거, 일치하는 Key가 있다면 Value, 없다면 null 반환
		
		System.out.println("4-----");
		System.out.println("remove(2) : " + map.remove(2));
		System.out.println("remove(5) : " + map.remove(5));
		System.out.println(map);
		
		
		// 5. void clear() : 모든 Entry 삭제
		
		
		// 6. boolean isEmpty() : 비어 있는지 확인
		System.out.println("clear() 전 isEmpty() : " + map.isEmpty());
		
		map.clear();
		System.out.println("clear() 전 isEmpty() : " + map.isEmpty());
	}
	
	/**
	 * Map 요소(Entry) 순차 접근 하기 1
	 * - Map.keyset() 이용하기
	 */
	public void method2() { 
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("학원", "서울시 중구");
		map.put("집", "서울시 관악구");
		map.put("롯데타워", "서울시 송파구");
		map.put("63빌딩", "서울시 영등포구");
		
		// Set<K> Map.keyset() : Map 에 Key만 뽑아내서 Set 형태로 반환
		Set<String> set = map.keySet();
		
		System.out.println("keyset : " + set);
		
		// 향상된 for 문 + Set
		for(String key : set)	System.out.printf("%-10s : %s \n", key, map.get(key));
	}
	
	/**
	 * Map 요소(Entry) 순차 접근 하기2
	 * - Map.entrySet() 이용하기

	 */
	public void method3() {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("학원", "서울시 중구");
		map.put("집", "서울시 관악구");
		map.put("롯데타워", "서울시 송파구");
		map.put("63빌딩", "서울시 영등포구");
		
		Set<Entry<String, String>>entrySet = map.entrySet();
		
		// 향상된 for문 + EntrySet
//		- Entry.getKey() : Key만 얻어오기 / -Entry.geValue() : Value만 얻어오기
		for(Entry<String, String> entry: entrySet) {
			System.out.printf("key : %-10s, value : %s \n", entry.getKey(), entry.getValue());
		}	
	}
	
	/**
	 * Map 활용하기 - DTO 대체하기
	 * - 서로 다른 데이터를 한번에 묶어서 관리해야 하는 경우
	 * 
	 */
	public void method4() {
		
		// DTO 이용
		Person p1 = new Person();
		p1.setName("홍길동");
		p1.setAge(25);
		p1.setGender('남');
		
		System.out.printf("이름 : %s, 나이 %d, 성별 %c\n", p1.getName(), p1.getAge(), p1.getGender());
		
		System.out.println("----");
		
		// DTO 대신 Map 활용하기
//		-> Key는 무조건 String 활용 (변수 이름이 대부분이기때문)
//		-> Value의 타입이 모두 다름 -> Object를 부모 타입 참조 변수로 활용 ~> 다형성 (업캐스팅 + 동적 바인딩)
		
		Map<String, Object> p2 = new HashMap<String, Object>();
		
		// 데이터 추가
		p2.put("name", "김길순");
		p2.put("age", 22); // int -> ㅑnteger 변환
		p2.put("gender", '여'); // ㅊhar -> Charatoer 변환
		
		// 데이터 얻어오기
		System.out.printf("이름 : %s, 나이 %d, 성별 %c\n", p2.get("name"), p2.get("age"), p2.get("gender"));
		// 동적바인딩 적용 각. Object.toString() -> String.toString() / Object.toString() -> Integer.toString() / Object.toString() -> Charater.toString()
	}
	
//	JS 객체 -> JSON -> Map -> (JACKSON 라이브러리) DTO
	
}
