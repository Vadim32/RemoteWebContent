package demidov.pkg.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateChangerUtils {

	 /*This method takes String representation of date and convert it in proper format of Date from java.util package
	***
	@param particularDate in String type
	@return properdate in Date format from java.util.Date 
	@throws ParseException if the beginning of the specified string cannot be parsed(if instead of number representation we put letters)*/
	public static Date dateConvertation(String particularDate) throws ParseException  {
			SimpleDateFormat simpDateFomat = new SimpleDateFormat("yyyy-MM-dd");
				Date theDate = new Date();
					theDate = simpDateFomat.parse(particularDate);	
						return theDate;	 
	    }
	
}
