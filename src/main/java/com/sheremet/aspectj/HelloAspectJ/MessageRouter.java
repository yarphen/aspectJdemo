package com.sheremet.aspectj.HelloAspectJ;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MessageRouter implements Router {
	private static final int USER_NAME_MINIMAL_LENGTH = 3;
	private static final int PASSWORD_MINIMAL_LENGTH = 3;
	private String username;
	public MessageRouter() {
		// TODO Auto-generated constructor stub
	}
	public void init(String user, String password) throws NoSuchElementException,IllegalAccessException {
		if (!getHashInstance().containsKey(user)){
			throw new NoSuchElementException();
		}
		if (!getHashInstance().get(user).equals(md5(password))){
			throw new IllegalAccessException();
		}
		username = user;
	}
	public void sendInfo(String address, Message info)throws IllegalArgumentException {
		if(!info.getReceiver().equals(address)||!info.getSender().equals(username)||!getHashInstance().containsKey(address))
			throw new IllegalArgumentException();
		if (!getMessageInstance().containsKey(address))
			getMessageInstance().put(address, new LinkedList<Message>());
		getMessageInstance().get(address).add(info);
	}
	public Message receiveInfo()throws NoSuchElementException  {
		Message m =  getMessageInstance().get(username).poll();
		if (m==null)throw new NoSuchElementException();
		return m;
	}
	public static void createAccount(String user, String password)throws IllegalArgumentException{
		if (user==null||password==null) throw new NullPointerException();
		if (user.length()<USER_NAME_MINIMAL_LENGTH||password.length()<PASSWORD_MINIMAL_LENGTH) throw new IllegalArgumentException();
		getHashInstance().put(user, md5(password));
	}
	public static String md5(String st) {
		MessageDigest messageDigest = null;
		byte[] digest = new byte[0];
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(st.getBytes());
			digest = messageDigest.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		BigInteger bigInt = new BigInteger(1, digest);
		String md5Hex = bigInt.toString(16);
		while( md5Hex.length() < 32 ){
			md5Hex = "0" + md5Hex;
		}
		return md5Hex;
	}
	private static class InfoHolder{
		private static HashMap<String,LinkedList<Message>>messageInstance;
		private static HashMap<String,String>hashInstance;
	}
	private static HashMap<String,LinkedList<Message>> getMessageInstance(){
		if (InfoHolder.messageInstance==null){
			InfoHolder.messageInstance = new HashMap<String, LinkedList<Message>>();
		}
		return InfoHolder.messageInstance;
	}
	private static HashMap<String,String> getHashInstance(){
		if (InfoHolder.hashInstance==null){
			InfoHolder.hashInstance = new HashMap<String, String>();
		}
		return InfoHolder.hashInstance;
	}
}

