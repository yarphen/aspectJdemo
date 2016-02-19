package com.sheremet.aspectj.HelloAspectJ;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main( String[] args ){
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
		String [] positive =	{"Hello!","How are you!","Nice to meet you too!","I'm very glad to see you!"};
		String [] negative =	{"Oh,s*t!","Hmm... it's disgusting!","You're ugly","F.. away"};
		final Talker talker1 = (Talker) context.getBean("John");
		talker1.setTalkInfo(positive);
		final Talker talker2 = (Talker) context.getBean("Jack");
		talker2.setTalkInfo(negative);
		Runnable action1 = new Runnable() {
			
			public void run() {
				try {
					talker1.talk(talker2.getName());
				} catch (Exception e) {
					//here will be printing user-generated exception
					e.printStackTrace();
				}
			}
		};
		Runnable action2 = new Runnable() {
			
			public void run() {
				try {
					talker2.talk(talker1.getName());
				} catch (Exception e) {
					//here will be printing user-generated exception
					e.printStackTrace();
				}
			}
		};
		
		new Thread(action1).start();
		new Thread(action2).start();
	}

}
