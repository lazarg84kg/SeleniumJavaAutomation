package com.unitedcloud.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigProperty {
	protected InputStream input = null;
	protected Properties prop = null;

	// Class that loads config.properties file, with methods that gets some
	// properties
	// eg. url, browser, username and password ...

	public ReadConfigProperty() {

		try {
			String filename = "com/unitedcloud/resources/config.properties";
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

	// methods which read url, browser, username and password from
	// config.properties file

	public String getUrl() {
		if (prop.getProperty("url") == null)
			return "";
		return prop.getProperty("url");
	}

	public String getBrowser() {
		if (prop.getProperty("browser") == null)
			return "";
		return prop.getProperty("browser");
	}

	public String getUsername() {
		if (prop.getProperty("username") == null)
			return "";
		return prop.getProperty("username");
	}

	public String getPassword() {
		if (prop.getProperty("password") == null)
			return "";
		return prop.getProperty("password");
	}

}
