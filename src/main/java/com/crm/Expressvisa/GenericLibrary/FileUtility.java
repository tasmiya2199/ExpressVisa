package com.crm.Expressvisa.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	public String readDataFromProperty(String key) throws IOException {
		FileInputStream fis=new FileInputStream(ipathconstants.propertypath);
	   Properties p=new Properties();
	   p.load(fis);
	  String data = p.getProperty(key);
	  return data; 
	}

}
