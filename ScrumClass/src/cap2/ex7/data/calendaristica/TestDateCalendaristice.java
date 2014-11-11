package cap2.ex7.data.calendaristica;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestDateCalendaristice {
	public static void main(String[] args) {
		// 1. initializare data curenta
		// 1.1 cu java.util.Date
		java.util.Date dataC = new java.util.Date();
		java.util.Date altaDataC = new java.util.Date();
		// 1.2 cu java.util.Calendar
		Calendar calendar = Calendar.getInstance();
		Calendar altCalendar = Calendar.getInstance();
		System.out.println("1.1 init Date: \n dataC -> " + dataC
				+ ", \n altaDataC -> " + altaDataC);
		System.out.println("1.2 init Calendare: \n calendar -> "
				+ calendar.getTime() + ", \n altCalendar -> "
				+ altCalendar.getTime());
		System.out.println("1.3 dataC==altaDataC : " + (dataC == altaDataC));
		System.out.println("1.4 calendar==altCalendar : "
				+ (calendar == altCalendar));
		System.out.println("1.5 dataC.equals(altaDataC) : "
				+ (dataC.equals(altaDataC)));
		System.out.println("1.6 calendar.equals(altCalendar) : "
				+ (calendar.equals(altCalendar)));
		System.out.println("1.7 dataC.equals(calendar.getTime()) : "
				+ (dataC.equals(calendar.getTime())));

		Date dataC_minus_1000ms = new Date(dataC.getTime() - 1000);
		System.out.println("1.8 dataC.after(dataC_minus_1000ms) : "
				+ (dataC.after(dataC_minus_1000ms)));
		Date dataC_plus_5000ms = new Date(dataC.getTime() + 5000);
		System.out.println("1.9 dataC.before(dataC_plus_5000ms) : "
				+ (dataC.before(dataC_plus_5000ms)));

		// 2. initializare data predefinita
		// 2.1 cu java.util.Date si SimpleDateFormat
		SimpleDateFormat f1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat f2 = new SimpleDateFormat("dd-MMM-yyyy hh24:mm:ss");
		try {
			java.util.Date d1 = f1.parse("01/09/2010");
			System.out.println("2.1 d1 : " + f2.format(d1) + "/" + d1.getTime()
					+ " milisecunde");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 2.2 cu java.util.Calendar si SimpleDateFormat
		Calendar c1 = f1.getCalendar();
		System.out.println("2.2 c1 : " + f2.format(c1.getTime()) + "/"
				+ c1.getTimeInMillis() + " milisecunde");
		// 2.3 prin modificare java.util.Calendar initial
		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.DAY_OF_MONTH, 1);
		c2.set(Calendar.MONTH, Calendar.SEPTEMBER);
		c2.set(Calendar.YEAR, 2010);
		c2.set(Calendar.HOUR_OF_DAY, 0);
		c2.set(Calendar.MINUTE, 0);
		c2.set(Calendar.SECOND, 0);
		c2.set(Calendar.MILLISECOND, 0);
		System.out.println("2.3 c2 : " + f2.format(c2.getTime()) + "/"
				+ c2.getTimeInMillis() + " milisecunde");

		// 3 Conversii
		// 3.1 java.util.Date -> java.util.Calendar
		java.util.Date d2 = new java.util.Date();
		Calendar c3 = Calendar.getInstance();
		c3.setTime(d2);
		System.out.println("3.1 d2.getTime(): " + d2.getTime()
				+ "-> c3.getTimeInMillis(): " + c3.getTimeInMillis());
		// 3.2 java.util.Calendar -> java.util.Date
		java.util.Date d3 = c3.getTime();
		System.out.println("3.2 c3.getTimeInMillis(): " + c3.getTimeInMillis()
				+ " -> d2.getTime(): " + d2.getTime());
		// 3.3 java.util.Date -> java.sql.Date
		java.sql.Date dSQL1 = new java.sql.Date(d2.getTime());
		System.out.println("3.3 d2.getTime(): " + d2.getTime()
				+ "-> dSQL1.getTime(): " + dSQL1.getTime());
		// 3.4 java.util.Calendar -> java.sql.Date
		java.sql.Date dSQL2 = new java.sql.Date(c3.getTimeInMillis());
		System.out.println("3.4 c3.getTimeInMillis(): " + c3.getTimeInMillis()
				+ "-> dSQL2.getTime(): " + dSQL2.getTime());

		// 4.Operatii cu date calendaristice
		// 4.1 Adunare 2 luni interval calendaristic
		SimpleDateFormat f3 = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c4 = Calendar.getInstance();
		System.out.println("4.1 Data start: " + f3.format(c4.getTime()));
		c4.add(Calendar.MONTH, 2);
		System.out.println("Data finala = data start + 2luni : "
				+ f3.format(c4.getTime()));
		// 4.2 Scadere 15 zile interval calendaristic
		Calendar c5 = Calendar.getInstance();
		System.out.println("4.2 Data start: " + f3.format(c5.getTime()));
		c5.add(Calendar.WEEK_OF_MONTH, -2);
		System.out.println("Data finala = data start - 2saptamini : "
				+ f3.format(c5.getTime()));
		// 4.3 Adunare interval 14 ore
		// fara trecere peste ordin (nr zilelor nu se schimba)
		SimpleDateFormat f4 = new SimpleDateFormat("HH:mm:ss");
		Calendar c6 = Calendar.getInstance();
		System.out.println("4.3 Timp start: " + f4.format(c6.getTime()));
		c6.roll(Calendar.HOUR_OF_DAY, 3);
		System.out.println("Timp final = timp start + 3ore : "
				+ f4.format(c6.getTime()));
		// 4.4 Scadere interval 25 secunde
		// fara trecere peste ordin (nr minutelor nu se schimba)
		Calendar c7 = Calendar.getInstance();
		System.out.println("4.4 Timp start: " + f4.format(c7.getTime()));
		c7.roll(Calendar.SECOND, -25);
		System.out.println("Timp final = timp start - 25secunde : "
				+ f4.format(c7.getTime()));
	}

}
