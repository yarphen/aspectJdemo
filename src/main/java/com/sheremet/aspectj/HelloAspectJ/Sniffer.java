package com.sheremet.aspectj.HelloAspectJ;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Sniffer implements InfoStealer{
	private HashMap<String,LinkedList<Message>> stealedData;
	public void stealInfo(String address, Message info) {
		if (!stealedData.containsKey(address)){
			stealedData.put(address, new LinkedList<Message>());
		}
		stealedData.get(address).add(info);
	}

	public List<Message> getInfo(String address) {
		return stealedData.get(address);
	}

}
