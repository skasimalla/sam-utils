package com.Sam.Util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class OneWayHash {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(oneWayHash("123456"));
		
	}
	
	public static String oneWayHash(String originalString)
	{
		MessageDigest digest;
		String outputString = "";
		try {
			digest = MessageDigest.getInstance("SHA-256");
		byte[] encodedhash = digest.digest(
				 originalString.getBytes(StandardCharsets.UTF_8));
		 outputString = Base64.getEncoder().encodeToString(encodedhash);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return outputString;
	}
}
