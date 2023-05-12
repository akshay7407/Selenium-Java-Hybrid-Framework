package java_practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class dateDemo {

	public static void main(String[] args) {
		Date d = new Date();
		
//		System.out.println(d.toString());
		
		SimpleDateFormat date1 = new SimpleDateFormat("M/d/yyyy");
		//print current date simple format 
		System.out.println(date1.format(d));
		//print current date in detailed 
		System.out.println(d.toString());
		
		
		/******************Calendar Class*******************/
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sd = new SimpleDateFormat("M/d/yyyy hh:mm:ss");
		System.out.println(sd.format(cal.getTime()));
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		

	}

}
