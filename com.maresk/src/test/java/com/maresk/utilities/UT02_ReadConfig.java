package com.maresk.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UT02_ReadConfig {

	public Properties prop;

	public UT02_ReadConfig() throws IOException {

		FileInputStream file = new FileInputStream("../com.maresk/config/config.properties");
		prop = new Properties();
		prop.load(file);
	}

	public String getUrl() {
		return prop.getProperty("url");

	}
	
	public String getuserid() {
		return prop.getProperty("userid");

	}
	
	public String getpassword() {
		return prop.getProperty("password");

	}
	
	public String gettestdatapath() {
		return prop.getProperty("TestDataPath");

	}

}
