package junzheng;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

	public static String format(Date date) {
		return sdf.format(date);
	}
}
