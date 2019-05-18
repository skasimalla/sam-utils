package com.Sam.Util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {
	
	public static void main(String[] args) {
		InetAddress ip;
		try {
			ip = InetAddress.getLocalHost();
			String s = ip.getCanonicalHostName() + "AtomicitySystems";
			s = "sandbox1" + "AtomicitySystems";
			System.out.println("Starting on" + s);
			s = OneWayHash.oneWayHash(s);
			String key = FileUtil.getInstance().getProp("key");
			System.out.println(s);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
