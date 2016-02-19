package com.sheremet.aspectj.HelloAspectJ;

public class Letter implements Message {
	private final String sender,receiver,text;
	public Letter(String sender, String receiver, String text) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.text = text;
	}

	public String getSender() {
		return sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return sender + ":" + text;
	}

}
