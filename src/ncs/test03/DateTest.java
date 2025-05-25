package ncs.test03;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		GregorianCalendar calBirthday = new GregorianCalendar(1987,4,27);
		GregorianCalendar calToday = new GregorianCalendar();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일 EEEE");
		
		Date date = calBirthday.getTime();		
		String birthday = sf.format(date);
		System.out.printf("생일 : %s\n",birthday);
		
		sf = new SimpleDateFormat("yyyy년 MM월 dd일");
		date = calToday.getTime();		
		String today = sf.format(date);
		System.out.printf("오늘 : %s\n",today);
		
		Long diff = calToday.getTimeInMillis() - calBirthday.getTimeInMillis();
		Long diffYear = diff/(1000L*60*60*24*365) + 1;
		System.out.printf("나이 : %d 세\n",diffYear);
		
	}

}
