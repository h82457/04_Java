package edu.kh.poly.pack3.run;

import edu.kh.poly.pack3.model.dto.Calculator;
import edu.kh.poly.pack3.model.dto.Calculator2;
import edu.kh.poly.pack3.model.dto.Machine;
import edu.kh.poly.pack3.model.dto.OOOCalculator;

public class CalculatorRun {
	public static void main(String[] args) {
		
		
		// 인터페이스 장점 : 
//		 상속 받은 클래스들의 형태가 똑같거나 비슷
//		코드 유지보수 시 참조하는 객체만 변경하면 유지 보수가 완료된다!!!
		
//		Calculator cal = new OOOCalculator();
		Calculator cal = new Calculator2();
		
//		System.out.println(cal.plus(1, 1));
//		System.out.println(cal.minus(2, 1));
//		System.out.println(cal.multi(2, 2));
//		System.out.println(cal.div(2, 2));
//		System.out.println(cal.mod(2, 1));
		System.out.println("---");
//		System.out.println(cal.sum(2, 1, 6));
//		System.out.println(cal.areaOfCircle(2));
		System.out.println(cal.rangeCheck(-110_000_000));
//		System.out.println(cal.pow(2, 3));
//		System.out.println(cal.toBinary(3));
//		System.out.println(cal.toHexadecimal(2024));
		
		
		// 참조 변수의 자료형을 Machine으로 강제 형변환 해야지만
		// powerOn(), powerOff() 호출 가능
		Machine machine = (Machine)cal;
		machine.powerOn();
		machine.powerOff();
		

	}
}


/**
 * 자바배열: 1개의 자료형 + 길이 고정, 지원하는 메서드X 
 * 
 * 컬렉션 : 자바에서 미리 만들어 제공하는 자료구조의 모음
 * 	List/Set의 공통 코드만 작성한 인터페이스(지을 이름이 없어서 그냥 collection이라고 함)
 * java collection - set list map
 * collecion - set list
 * 
 * 
 */
