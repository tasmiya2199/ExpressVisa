package com.crm.Expressvisa.GenericLibrary;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaUtility {
	
	
	public String dataAndTime(String Pattern) {
		Calendar c = Calendar.getInstance();
		Date d = c.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat(Pattern);
		String value = sdf.format(d);
		return value;
	}

}
