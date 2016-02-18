package com.sheremet.aspectj.HelloAspectJ;

import java.util.List;

public interface InfoStealer {
	void stealInfo(String address, Message info);
	List<Message> getInfo(String address);
}
