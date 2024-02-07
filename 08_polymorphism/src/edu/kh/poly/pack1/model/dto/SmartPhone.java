package edu.kh.poly.pack1.model.dto;

// 부모 클래스 역할
public class SmartPhone {
	private String display; // 화면
	private String newsAgency; // 통신사
	private String ap;	// 스마트폰 cpu
	
	// 기본 생성자 자동 완성 : ctrl + space  -> enter
	public SmartPhone() {}

	// 매개 변수 생성자		단축키) : alt [+shift] + s -> o
	public SmartPhone(String display, String newsAgency, String ap) { 
		super();
		this.display = display;
		this.newsAgency = newsAgency;
		this.ap = ap;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getNewsAgency() {
		return newsAgency;
	}

	public void setNewsAgency(String newsAgency) {
		this.newsAgency = newsAgency;
	}

	public String getAp() {
		return ap;
	}

	public void setAp(String ap) {
		this.ap = ap;
	}

	// toString() 오버라이딩 자동 완성 : alt [+shift] + s -> s
	@Override
	public String toString() {
		return "SmartPhone [display=" + display + ", newsAgency=" + newsAgency + ", ap=" + ap + "]";
	}

	
	
	
}
