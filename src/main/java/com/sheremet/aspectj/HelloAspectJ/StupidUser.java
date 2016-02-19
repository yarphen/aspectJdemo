package com.sheremet.aspectj.HelloAspectJ;

import java.util.NoSuchElementException;
import java.util.Random;

public class StupidUser implements Talker {
	private static final int MAGIC_NUMBER = 10;
	private String[]phrases ; 
	public String[] getTalkInfo() {
		return phrases;
	}
	public void setTalkInfo(String[] phrases) {
		this.phrases = phrases;
	}
	private Router router; ; 
	private String myname;
	public StupidUser(String name,  Router r) throws StupidUserException {
		MessageRouter.createAccount(name, name);
		this.myname = name;
		this.router = r;
		try {
			r.init(name, name);
			return;
		} catch (NoSuchElementException e) {
			System.err.println("Where is the Programmer!!1!!1!11 Something went wrong");
		} catch (IllegalAccessException e) {
			System.err.println("This stupid computer forgot my password!!!11!1!1");
		}
		throw new StupidUserException();
	}
	public void talk(String anotherTalker) throws StupidUserException {
		//he does not read messages at all
		//he just talks and talks
		Random r = new Random();
		while(true){
			int randomNumber = r.nextInt(phrases.length+1);
			String text = (randomNumber==phrases.length)?anotherTalker:(phrases[randomNumber]);
			router.sendInfo(anotherTalker, new Letter(myname, anotherTalker, text ));
			//just for lulz
			if (r.nextInt(MAGIC_NUMBER)==0)throw new StupidUserException();
		}
	}
	public String getName() {
		return myname;
	}

}
