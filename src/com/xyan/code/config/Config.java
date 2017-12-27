package com.xyan.code.config;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.velocity.app.Velocity;

/**
 * 读取.properties配置文件的内容至Map中。
 */
public class Config {
	private static Config instance;
	private Map<String, String> properties;

	private Config() {
		properties = read("config");
	}

	public static Config getInstance() {
		if (instance == null) {
			instance = new Config();
		}
		return instance;
	}

	/**
	 * 读取.properties配置文件的内容至Map中
	 * @param propertiesFile
	 * @return
	 */
	private static Map<String, String> read(String propertiesFile) {
		ResourceBundle rb = ResourceBundle.getBundle(propertiesFile);
		Map<String, String> map = new HashMap<String, String>();
		Enumeration<String> enu = rb.getKeys();
		while (enu.hasMoreElements()) {
			String key = enu.nextElement();
			String value = rb.getString(key);
			map.put(key, value);
		}
		return map;
	}

	public String getProperty(String pName) {
		return properties.get(pName);
	}

	public String getDatabaseDriver() {
		return getProperty("driver");
	}

	public String getDatabaseURL() {
		return getProperty("url");
	}

	public Properties getDatabaseProperty() {
		Properties databaseProperties = new Properties();
		databaseProperties.put("user", getProperty("user"));
		databaseProperties.put("password", getProperty("pwd"));
		databaseProperties.put("remarksReporting",
				getProperty("remarksReporting"));
		return databaseProperties;
	}

	public void initVelocity() {
		Properties properties = new Properties();
		properties.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, Datas.path);
		properties.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
		properties.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
		properties.setProperty("file.resource.loader.class",
				"org.apache.velocity.runtime.resource.loader.FileResourceLoader");
		properties.setProperty(Velocity.RESOURCE_LOADER, "file");
		properties.setProperty(Velocity.FILE_RESOURCE_LOADER_CACHE, "true");
		Velocity.init(properties);
	}

}
