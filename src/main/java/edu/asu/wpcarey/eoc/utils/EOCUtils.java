package edu.asu.wpcarey.eoc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EOCUtils {
	public static String convertDateToString(Date date, String format) {
		final SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}

	public static Date convertStringToDate(String date, String format) {
		final SimpleDateFormat formatter = new SimpleDateFormat(format);

		try {
			final Date dateObject = formatter.parse(date);
			return dateObject;
		} catch (final ParseException e) {
			return null;
		}
	}
}
