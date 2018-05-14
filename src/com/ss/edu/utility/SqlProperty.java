package com.ss.edu.utility;

import java.io.InputStream;
import java.util.Properties;

public class SqlProperty {

	private static Properties properties;
	
	static {
		properties = new Properties();		
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream inputStream = classLoader.getResourceAsStream("sql.properties");
			properties.load(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		public static String get(String name) {
			if(properties.containsKey(name)) {
				return properties.getProperty(name);
			}
			throw new RuntimeException("Property key not found");
		}	
}