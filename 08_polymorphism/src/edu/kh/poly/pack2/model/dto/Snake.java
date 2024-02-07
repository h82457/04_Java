package edu.kh.poly.pack2.model.dto;

public class Snake extends Animal {

	private boolean poison;
	
	// 기본 생성자
	public Snake() {}
	
	// 매개 변수 생성자
	public Snake(String type , boolean poison) {
		super(type);
		this.poison = poison;
	}
	// getter/setter 
	public boolean isPoison() {
		return poison;
	}

	public void setPoison(boolean poison) {
		this.poison = poison;
	}
	
	// 추상 메서드 오버라이딩
	@Override
	public void eat() {
		System.out.println("뱀은 한번에 삼켜서 천천히 소화시킴");
	}

	@Override
	public void sleep() {
		System.out.println("뱀은 똬리를 틀고 잔다.");
	}
	
	@Override
	public String toString() {
		return super.toString() + " / 독  유무 : " + poison;
	}

}
