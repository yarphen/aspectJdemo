package com.sheremet.aspectj.HelloAspectJ;

import java.util.NoSuchElementException;

public interface Router {
	void sendInfo(String address, Message info);
	Message receiveInfo();
	void init(String name, String password) throws NoSuchElementException, IllegalAccessException;
}
