/**
 * 
 */
package com.org.doorstep.daoimpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author hariharank12
 *
 */
public class DateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		// /date.
		System.out.println(dateFormat.format(date));
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		DateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd");
		// cal.set
		System.out.println(dateFormat1.format(cal.getTime()));

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		// calendar.gett
		System.out.println(calendar.getTime());

		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(date);
		calendar1.add(Calendar.DATE, 1);
		calendar1.set(Calendar.MILLISECOND, 0);
		calendar1.set(Calendar.SECOND, 0);
		calendar1.set(Calendar.MINUTE, 0);
		calendar1.set(Calendar.HOUR_OF_DAY, 0);
		System.out.println(calendar1.getTime());

		System.out.println(Calendar.getInstance().getTime());
	}
}
