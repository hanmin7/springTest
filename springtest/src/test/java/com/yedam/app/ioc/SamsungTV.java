package com.yedam.app.ioc;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class SamsungTV implements TV {

	//@Autowired  //주입 factory.getBean("speaker") 와 같은 역할 component되어있는 스피커를 가져옴. 덮어쓰는건 component 불러쓰는건 autowired
	//@Qualifier("SonySpeaker") //component 한 스피커가 2개(여러개)일 때 가져올꺼 지정해주는거
	//@Resource(name="sonySpeaker")  //위의 두개가 쓰기 귀찮으면 리소스 사용. component에 이름지정안해주면 name에 클래스이름 첫글자 소문자로 시작한 이름.
	private Speaker speaker;	
	private int price;
	
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	//생성자 방식으로 의존관계 객체 주입
	/*
	 * public SamsungTV(Speaker speaker, int price) { this.speaker = speaker;
	 * this.price = price; }
	 */
	public SamsungTV() {}
	
	public void initMethod() {
		System.out.println("SamsungTV 초기화");
	}
	@Override
	public void powerOn() {
		System.out.println("SamsungTV powerOn 가격:");
	}
	@Override
	public void powerOff() {
		System.out.println("SamsungTV powerDown");
	}
	@Override
	public void volumeUp() {
		//speaker = new SonySpeaker();
		speaker.volumeUp();
		//System.out.println("SamsungTV volumeUp");
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();
		//System.out.println("SamsungTV volumeDown");
	}	
}
