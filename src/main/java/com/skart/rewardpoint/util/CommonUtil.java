
/**
 * 
 */
package com.skart.rewardpoint.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class will contain util methods
 *
 */
public class CommonUtil {
	
	/**
	Make an int Month from a date
	*/
	public static String getMonthInt(Date date) {
		//Date date = new Date();
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MMM");
	    String month = dateFormat.format(date);
	    
	    return month;
	}
	
	/**
	Make an int Year from a date
	*/
	public static int getYearInt(Date date) {
		//Date date = new Date();
	    SimpleDateFormat dateFormat = new SimpleDateFormat("YY");
	    return Integer.parseInt(dateFormat.format(date));
	}	
	
	public static Date StringToDateConverter(String sourceFormat,String date) throws ParseException 
	{
		SimpleDateFormat myFormat = new SimpleDateFormat(sourceFormat);
		return myFormat.parse(date);
	}

}
