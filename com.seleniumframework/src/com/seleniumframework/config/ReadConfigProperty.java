package com.seleniumframework.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigProperty {
	protected InputStream input = null;
	protected Properties prop = null;

	// Class that loads config.properties file, with methods that gets some
	// properties
	// eg. url, browser etc...

	public ReadConfigProperty() {
		String filename = "com/seleniumframework/resources/config.properties";
		try {
			input = ReadConfigProperty.class.getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				return;
			}
			prop = new Properties();
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// getting url from config file
	public String getUrl() {
		if (prop.getProperty("url") == null)
			return "";
		return prop.getProperty("url");
	}

	// getting browser from config file(Chrome or firefox)
	public String getBrowser() {
		if (prop.getProperty("browser") == null)
			return "";
		return prop.getProperty("browser");
	}

}
