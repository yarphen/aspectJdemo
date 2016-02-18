package com.sheremet.aspectj.HelloAspectJ;

public interface Router {
	void sendInfo(String address, Message info);
	Message receiveInfo();
}
