package com.yedam.app.ioc;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUserContainer {

	public static void main(String[] args) {

		AbstractApplicationContext  factory =
				new GenericXmlApplicationContext("applicationContext.xml");
		/*TV tv = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff(); */

		Speaker speaker1 = (Speaker) factory.getBean("sony");
		Speaker speaker2 = (Speaker) factory.getBean("sony");
		System.out.println(speaker1 == speaker2 ? "yes" : "no");
		//applicationContext.xml 에서 빈 scope="prototype" 하면 다르다고나옴. (새로 생성)
		// scope="singleton" 하면 같다고 나옴. (생성 x  생성되어있는거 가져와서 씀)
	}
}
