package com.ge.get.controller;

import org.apache.log4j.Logger;


/**
 * @author cristi.chelaru
 * @version 0.1
 */
public class Test {
	private static final Logger LOGGER = Logger.getLogger(Test.class);
	
	public static void main(String []args) {
		String cityName = null;
		
		if(args.length != 0){
			cityName = args[0];
			LOGGER.info("========================================================");
			LOGGER.info("New city searched: " + cityName);
		}
		
		//call ApiRequest and get response
		String response = ApiRequest.sendReq(cityName);

		//print result
		System.out.println(response);
		
		//generate JSON
		JsonCreator.generateJson(response);
	}
}
