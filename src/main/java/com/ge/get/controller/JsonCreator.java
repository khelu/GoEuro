package com.ge.get.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ge.get.pojo.City;
import com.ge.get.util.Constants;

/**
 * @author cristi.chelaru
 *
 */
public class JsonCreator {
	private static final Logger LOGGER = Logger.getLogger(JsonCreator.class);
	
	protected static void generateJson(String apiResponse)
    {
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<City> listCities = new ArrayList<>();
		try {
			listCities= mapper.readValue(apiResponse, new TypeReference<ArrayList<City>>(){});
		} catch (JsonGenerationException e) {
			LOGGER.error("Error generating JSON: ", e);
		} catch (JsonMappingException e) {
			LOGGER.error("Error generating JSON: ", e);
		} catch (IOException e) {
			LOGGER.error("Error generating JSON: ", e);
		}
		
		String file = Constants.FILE_NAME + Constants.FILE_TYPE;
		
		//call CsvCreator
		CsvCreator.generateCsvFile(file, listCities);
    }
}
