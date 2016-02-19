package com.sheremet.aspectj.HelloAspectJ;

public interface Talker {
	void talk(String anotherTalker) throws Exception;
	String[] getTalkInfo();
	void setTalkInfo(String[] phrases);
	String getName();
}
