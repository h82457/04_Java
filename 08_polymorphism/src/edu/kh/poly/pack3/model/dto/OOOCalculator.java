package edu.kh.poly.pack3.model.dto;

// 인터페이스 Calulator와 Machine 을 상속 받아옴

// 									v인터페이스는 다중 상속이 가능
public class OOOCalculator implements Calculator, Machine{

	// 인터페이스 Calulator 에서 입력한 추상 메서드 오버라이딩
	@Override
	public int plus(int a, int b) { return a+b; }

	@Override
	public int minus(int a, int b) { return a-b; }

	@Override
	public int multi(int a, int b) { return a*b; }

	@Override
	public double div(int a, int b) {
		if(b == 0) return 0.0;
		return (double)a/b;
	}

	@Override
	public int mod(int a, int b) { return a%b; }

	@Override
	public int sum(int... numbers) { //	가변인자(...) : 전달 인자의 개수가 변할수 있는 매개 변수
//										ㄴ numbers는 int 배열타입, (+ 가변인자 예시: printf)
		int sum = 0;
		
		for(int i : numbers) sum += i;
		return sum;
	}

	@Override
	public double areaOfCircle(double r) { return Calculator.PI * r * r; }

	@Override
	public boolean rangeCheck(int num) {
		if(num < Calculator.MAX_NUM && num > Calculator.MIN_NUM) return true;
		else return false;
	}

	@Override
	public int pow(int a, int x) { return (int) Math.pow(a, x); }

	@Override
	public String toBinary(int num) { return Integer.toBinaryString(num); }

	@Override
	public String toHexadecimal(int num) { return Integer.toHexString(num); }

	
	// 인터페이스 Machine 에서 입력한 추상 메서드 오버라이딩
	@Override
	public void powerOn() {
		System.out.println("실행");
	}

	@Override
	public void powerOff() {
		System.out.println("종료");
	}
}
