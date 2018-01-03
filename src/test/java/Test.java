import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "2017-12-08";
		Date dt = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dt = format1.parse(str);
			System.out.println(dt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
