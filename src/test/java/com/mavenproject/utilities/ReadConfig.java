package com.mavenproject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	public ReadConfig()
	{
		File src = new File("./src\\test\\resources\\Configuration\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}
	} 
	
	public String getApplicationURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getChromePath()
	{
		String churl = pro.getProperty("chromepath");
		return churl;
	}
	
	public String getFirefoxPath()
	{
		String ffurl = pro.getProperty("firefoxpath");
		return ffurl;
	}
	 
	public String getIePath()
	{
		String ieurl = pro.getProperty("iepath");
		return ieurl;
	}
	

	}
