package com.crm.Expressvisa.Testscripts;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateAndTime {
	
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		Date d = c.getTime();
		System.out.println(d);
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy  hh-mm-ss");
	    String value = sdf.format(d);
	    System.out.println(value);
	}

}
