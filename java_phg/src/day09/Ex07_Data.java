package day09;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex07_Data {

	public static void main(String[] args) throws ParseException {
		
		Date data = new Date();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String str = format.format(data);
		
		System.out.println(str);
		
		str = "2024-01-01 14:30:00";
		
		data = format.parse(str);
		
		System.out.println(data);
	}

}
