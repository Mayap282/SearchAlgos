package edu.util.lib.prac;
import java.util.*;
import java.sql.Date;
import java.text.DateFormat;

public class TestDates {

	public static void Testdates(){
		Date d1 = new Date(1000000000000L);
		System.out.println("\n1st date "+ d1.toString());
		d1.setTime(d1.getTime()+3600000);
		System.out.println(d1.toString());
		
		Calendar c = Calendar.getInstance();
		c.setTime(d1);
		if(Calendar.SUNDAY==c.getFirstDayOfWeek())
			System.out.println("sunday is first day f the week");
		System.out.println("trillionth milli day of the week is"+ c.get(Calendar.DAY_OF_WEEK));
		c.add(Calendar.MONTH, 1);
		//Date d2 = (Date) c.getTime();
		//System.out.println("new date"+d2.toString());
		c.add(Calendar.HOUR, -4);
		System.out.println(c.getTime());
		c.add(Calendar.YEAR, 5);
		System.out.println(c.getTimeInMillis());
		
		DateFormat[] dfa = new DateFormat[3];
		dfa[0]=DateFormat.getInstance();
		dfa[1]=DateFormat.getDateInstance();
		dfa[2]=DateFormat.getDateInstance(DateFormat.MEDIUM);
		
		for(DateFormat df : dfa)
			System.out.println(df.format(d1));
		System.out.println("\\");
		String s="abc.cdw.df";
		String [] tokens = s.split("\\.");
		for(String s1 : tokens){
			System.out.println(">"+s1+"<");
		}
		
	}
}
