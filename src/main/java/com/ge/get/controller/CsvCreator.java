package com.ge.get.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ge.get.pojo.City;

/**
 * @author cristi.chelaru
 *
 */
public class CsvCreator {
	private static final Logger LOGGER = Logger.getLogger(CsvCreator.class);
	
	protected static void generateCsvFile(String fileName,
			ArrayList<City> cities) {
		
		try {
			FileWriter writer = new FileWriter(fileName, true);

			writer.append("_id");
			writer.append(',');
			writer.append("name");
			writer.append(',');
			writer.append("type");
			writer.append(',');
			writer.append("latitude");
			writer.append(',');
			writer.append("longitude");
			writer.append('\n');

			for (City city : cities) {
				if (city.get_id() != null) {
					writer.append(String.valueOf(city.get_id()));
				} else {
					writer.append("");
				}
				writer.append(',');
				writer.append(city.getName());
				writer.append(',');
				writer.append(city.getType());
				writer.append(',');
				if (city.getGeo_position().getLatitude() != null) {
					writer.append(String.valueOf(city.getGeo_position()
							.getLatitude()));
				} else {
					writer.append("");
				}
				writer.append(',');
				if (city.getGeo_position().getLongitude() != null) {
					writer.append(String.valueOf(city.getGeo_position()
							.getLongitude()));
				} else {
					writer.append("");
				}
				writer.append('\n');
			}

			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			LOGGER.error("Error generating csv: ", e);
		}
	}
}
