package com.sheremet.aspectj.HelloAspectJ;

public class StupidUserException extends Exception {
	@Override
	public String getMessage() {
		return "God of Programmers, please fix this s*t!";
	}
}
