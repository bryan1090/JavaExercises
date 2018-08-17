package com.ec.clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServiceVehicleVerification {

	

	public boolean isValidLicensePlateNumber(String license) {

		String regex1 = "[a-zA-Z][a-zA-Z][a-zA-Z][-][0-9][0-9][0-9][0-9]";
		String regex2 = "[a-zA-Z][a-zA-Z][-][0-9][0-9][0-9][0-9]";

		Pattern pattern1 = Pattern.compile(regex1);
		Matcher matcher1 = pattern1.matcher(license);

		Pattern pattern2 = Pattern.compile(regex2);
		Matcher matcher2 = pattern2.matcher(license);

		if (matcher1.matches() || matcher2.matches()) {
			System.out.println("Placa: " + license);
			return true;

		} else {
			System.out.println("¡License" + "'" + license + "'" + "is not valid!");
			return false;

		}
	}

	public boolean isValidDate(String dateString) {

		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		dateformat.setLenient(false);
		Date date = new Date();
		Calendar cal = Calendar.getInstance();

		try {
			date = dateformat.parse(dateString);
			cal.setTime(date);
			System.out.println(dateString);
//			System.out.println("Date(Java): " + cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + "/"
//					+ cal.get(Calendar.YEAR));
			return true;

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("¡Date" + "'" + dateString + "'" + "is not valid!");
			return false;

		}
	}

	public boolean checkDayRestriction(String dateString, String lastDigit) {

		Calendar cal = Calendar.getInstance();
		int lastNumber = Integer.parseInt(lastDigit);
		boolean restringedDay = false;

		cal = stringToCalendar(dateString);

		System.out.println("día de la semana: " + cal.get(Calendar.DAY_OF_WEEK));
		System.out.println("ultimo digito: " + lastNumber);

		switch (cal.get(Calendar.DAY_OF_WEEK)) {
		case 2:
			if (lastNumber == 1 || lastNumber == 2) {
				restringedDay = true;
			}
			break;
		case 3:
			if (lastNumber == 3 || lastNumber == 4) {
				restringedDay = true;
			}
			break;
		case 4:
			if (lastNumber == 5 || lastNumber == 6) {
				restringedDay = true;
			}
			break;
		case 5:
			if (lastNumber == 7 || lastNumber == 8) {
				restringedDay = true;
			}
			break;
		case 6:
			if (lastNumber == 9 || lastNumber == 0) {
				restringedDay = true;
			}
			break;
		default:
			break;
		}
		System.out.println("dia con restriccion: "+restringedDay);
		return restringedDay;
	}

	public boolean isValidTime(String time) {
		String regex1 = "([0-1]{0,1}[0-9]|2[0-3]):([0-5][0-9])";

		Pattern pattern1 = Pattern.compile(regex1);
		Matcher matcher1 = pattern1.matcher(time);

		if (matcher1.matches()) {
			System.out.println("Tiempo: " + time);
			return true;
		} else {
			return false;
		}

	}

	public boolean checkTimeRestriction(String time) {
		boolean restringedHour = false;
		
		Date date=new Date();
		

		
		SimpleDateFormat dateformat = new SimpleDateFormat("hh:mm");
		try {
			date=dateformat.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
					
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		Calendar startTime1 = Calendar.getInstance();
		Calendar endTime1 = Calendar.getInstance();
		Calendar startTime2 = Calendar.getInstance();
		Calendar endTime2 = Calendar.getInstance();

		System.out.println("time: " + date.getHours() + ":" + date.getMinutes());
		
		cal.set(0, 0, 0, date.getHours(), date.getMinutes(), 0);

		//restringed schedules
		startTime1.set(0, 0, 0, 7, 0, 0);
		endTime1.set(0, 0, 0, 9, 30, 0);
		startTime2.set(0, 0, 0, 16, 0, 0);
		endTime2.set(0, 0, 0, 19, 30, 0);

		//compairing input hour against ranges
		if (cal.after(startTime1) && cal.before(endTime1)) {
			restringedHour = true;
			System.out.println("esta en el rango 1");
		} else if (cal.after(startTime2) && cal.before(endTime2)) {
			restringedHour = true;
			System.out.println("esta en el rango 2");
		}

		return restringedHour;
	}

	public Calendar stringToCalendar(String dateString) {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
//		dateformat.setLenient(false);
		Date date = new Date();
		Calendar cal = Calendar.getInstance();

		try {
			date = dateformat.parse(dateString);
			cal.setTime(date);
//			System.out.println("Date(Java): " + cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + "/"
//					+ cal.get(Calendar.YEAR));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("*¡Date" + "'" + dateString + "'" + "is not valid!");

		}
		return cal;
	}

	

}
