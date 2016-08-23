package com.ge.get.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;

import com.ge.get.util.Constants;

/**
 * @author cristi.chelaru
 *
 */
public class ApiRequest {
	private static final Logger LOGGER = Logger.getLogger(ApiRequest.class);
	
	protected static String sendReq(String cityName) {
		String url = Constants.URL;
		StringBuffer response = new StringBuffer();
		
		if(cityName != null){
			url += cityName;
		}
		
		URL obj = null;
		try {
			obj = new URL(url);
		} catch (MalformedURLException e) {
			LOGGER.error("Error creating URL: ", e);
		}

		String inputLine;
		try {
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", Constants.USER_AGENT);
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		} catch (IOException e) {
			LOGGER.error("Error opening connection | writing response: ", e);
		}	

		
		return response.toString();
	}
}
