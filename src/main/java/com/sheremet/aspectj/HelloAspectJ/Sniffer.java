package com.sheremet.aspectj.HelloAspectJ;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Sniffer implements InfoStealer{
	private HashMap<String,LinkedList<Message>> stealedData;
	public Sniffer() {
		stealedData = new HashMap<String, LinkedList<Message>>();
		System.out.println("Sniffer created!");
		System.out.println("We wish you funny reading:)");
		System.out.println();
	}
	public synchronized void stealInfo(String address, Message info) {
		if (!stealedData.containsKey(address)){
			stealedData.put(address, new LinkedList<Message>());
		}
		stealedData.get(address).add(info);
		System.out.println(info);
	}

	public List<Message> getInfo(String address) {
		return stealedData.get(address);
	}

}
