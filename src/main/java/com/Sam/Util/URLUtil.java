package com.Sam.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLUtil {
	public static URLUtil x;

	public static URLUtil getInstance() {
		if (x == null) {
			x = new URLUtil();
		}
		return x;
	}

	public String readUrl(String urlString) {
		BufferedReader reader = null;
		StringBuffer buffer = new StringBuffer();
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);
			if (reader != null)
				reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buffer.toString();
	}
}
