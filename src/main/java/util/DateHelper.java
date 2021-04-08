package util;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateHelper {

	private static final DateTimeFormatter PATTERN_YYYYMMDD = DateTimeFormatter.ofPattern("yyyyMMdd");

	private static final String HH__mm__ss = "HH:mm:ss";

	private static final String yyyyMMdd = "yyyyMMdd";
	private static final String yyyyMM = "yyyyMM";
	private static final String yyyy_MM_dd = "yyyy-MM-dd";

	private static final String yyyy_MM_dd_HH_mm_SS = "yyyy-MM-dd HH:mm:ss";
	private static final String yyyy_MM_dd_HH_mm_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";

	private static final String yyyyMMddHHmmSS = "yyyyMMddHHmmss";

	private static final String HH_mm = "HH:mm";

	/**
	 * 界面，其他输出统一标准格式
	 */
	private static final String STANDARD_YYYY__MM__DD_HH_MM = "yyyy.MM.dd HH:mm:ss";

	private static final String STANDARD_YYYY__MM__DD = "yyyy.MM.dd";

	public static Date DATE_1970_01_01;

	public static Date DATE_1970_01_02;

	static {
		try {
			DATE_1970_01_01 = new SimpleDateFormat(yyyy_MM_dd_HH_mm_SS).parse("1970-01-01 00:00:00");
			DATE_1970_01_02 = new SimpleDateFormat(yyyy_MM_dd_HH_mm_SS).parse("1970-01-02 00:00:00");

		} catch (ParseException e) {
			// ignore
		}
	}

	public static Date parseHHmm(String hhmm) {
		if (StringUtils.isEmpty(hhmm)) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(HH_mm);
		try {
			return sdf.parse(hhmm);
		} catch (Exception e) {
			return null;
		}
	}

	public static Date parseyyyyMMdd(String str) {
		if (StringUtils.isEmpty(str)) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(yyyy_MM_dd);
		try {
			return sdf.parse(str);
		} catch (Exception e) {
			return null;
		}
	}

	public static String toHH__mm__ss(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat(HH__mm__ss);
		return format.format(date);
	}

	public static String toStandard(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat(STANDARD_YYYY__MM__DD_HH_MM);
		return format.format(date);
	}

	public static String toSTANDARD_YYYY__MM__DD(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat(STANDARD_YYYY__MM__DD);
		return format.format(date);
	}



	public static String toYYYYMMDD(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat(yyyyMMdd);
		return format.format(date);
	}

	public static String toYYYYMM(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat(yyyyMM);
		return format.format(date);
	}

	public static String toYYYYMMDD(LocalDate date) {
		if (date == null) {
			return "";
		}
		return PATTERN_YYYYMMDD.format(date);
	}

	public static String toYYYY_MM_DD(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat(yyyy_MM_dd);
		return format.format(date);
	}

	public static String nowYYYY_MM_DD_HH_MM_SS() {
		SimpleDateFormat format = new SimpleDateFormat(yyyy_MM_dd_HH_mm_SS);
		return format.format(new Date());
	}

	public static String nowYYYY_MM_DD_HH_MM_SS_SSS() {
		SimpleDateFormat format = new SimpleDateFormat(yyyy_MM_dd_HH_mm_SS_SSS);
		return format.format(new Date());
	}

	public static long timeGap(long timeStamps) {
		return (System.currentTimeMillis() - timeStamps);
	}


	public static String toYYYY_MM_DD_HH_MM_SS(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat(yyyy_MM_dd_HH_mm_SS);
		return format.format(date);
	}

	public static String toYYYY_MM_DD_HH_MM_SSEscape1970(Date date) {
		if (date == null || isDefaultDate(date)) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat(yyyy_MM_dd_HH_mm_SS);
		return format.format(date);
	}

	public static String toHH_MM_SS(LocalTime localTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(HH__mm__ss);
		return localTime.format(formatter);
	}

	public static Date parseYYYYMMDD(String source){
		SimpleDateFormat format = new SimpleDateFormat(yyyyMMdd);
		try {
			return format.parse(source);
		} catch (Exception e) {
			return null;
		}
	}

	public static Date parseYYYY_MM_DD_HH_MM_SS(String source){
		SimpleDateFormat format = new SimpleDateFormat(yyyy_MM_dd_HH_mm_SS);
		try {
			return format.parse(source);
		} catch (Exception e) {
			return null;
		}
	}

	public static Date parseYYYYMMDDHHMMSS(String source){
		SimpleDateFormat format = new SimpleDateFormat(yyyyMMddHHmmSS);
		try {
			return format.parse(source);
		} catch (Exception e) {
			return null;
		}
	}

	public static String toYYYYMMDDHHMMSS(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat(yyyyMMddHHmmSS);
		return format.format(date);
	}

	public static String toMMSS(long diff) {
		long min = diff / (60 * 1000);
		long sec = (long)Math.ceil(((double)diff/1000d - min*60d));
		if (sec == 60) {
			min += 1;
			sec = 0;
		}
		return min == 0 ? String.format("%s秒", sec) : String.format("%s分%s秒", min, sec);
	}

	public static boolean isSameDay(Date date1, Date date2) {
		if (date1 == null && date2 == null) {
			return true;
		}
		if (date1 == null || date2 == null) {
			return false;
		}
		return date1.getYear() == date2.getYear()
				&& date1.getMonth() == date2.getMonth()
				&& date1.getDate() == date2.getDate();
	}

	public static int minus(Date date1, Date date2) {
		if (!DateHelper.isDefaultDate(date1) && !DateHelper.isDefaultDate(date2)){
			return (int) (date1.getTime() - date2.getTime());
		}
		return 0;
	}
	public static boolean isDefaultDate(Date date) {
		if (date == null) {
			return true;
		}
		return DATE_1970_01_01.compareTo(date) == 0;
	}

	@Deprecated
	public static Date getDate0Clock(long now) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(now);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}


	/**
	 * 获取指定时间的凌晨时间
	 * @param date
	 * @return
	 */
	public static Date getDateAtMidnight(Date date) {
		if (date == null) {
			return null;
		}
		LocalDateTime localDateTime = date2LocalDateTime(date);
		LocalDateTime  dateTimeAtMidnight = LocalDateTime.of(localDateTime.toLocalDate(), LocalTime.MIDNIGHT);
		return localDateTime2Date(dateTimeAtMidnight);
	}

	/**
	 * date string 转 LocalDate, pattern为string的样式，如yyyy-MM-dd
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static LocalDate parseLocalDate(String dateStr, String pattern) {
		if (StringUtils.isEmpty(dateStr) || StringUtils.isEmpty(pattern)) {
			return null;
		}
		try {
			return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
		} catch (Exception e) {
			return null;
		}
	}

	public static LocalDateTime date2LocalDateTime(Date date, ZoneId zoneId) {
		if (date == null) {
			return null;
		}
		Instant timestamp =date.toInstant();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(timestamp, zoneId);
		return localDateTime;
	}

	public static LocalDateTime date2LocalDateTime(Date date) {
		return date2LocalDateTime(date, ZoneId.systemDefault());
	}

	public static Date localDateTime2Date(LocalDateTime localDateTime) {
		return localDateTime2Date(localDateTime, null);
	}

	public static Date localDateTime2Date(LocalDateTime localDateTime, ZoneId zoneId) {
		if (localDateTime == null) {
			return null;
		}
		if (zoneId == null) {
			zoneId = ZoneId.systemDefault();
		}
		ZonedDateTime zdt = localDateTime.atZone(zoneId);
		return Date.from(zdt.toInstant());
	}

	public static int getYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	public static int getMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH);
	}

	public static String getYearStr(Date date) {
		return String.valueOf(getYear(date));
	}

	public static int getNowYear() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.YEAR);
	}

	public static boolean isNowYear(Date date) {
		return DateHelper.getYear(date) == DateHelper.getNowYear();
	}

	/**
	 * 获取当天剩余秒数
	 * @return
	 */
	public static long getRemainSecondsOfToday() {
		LocalDateTime endOfDay = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
		return  ChronoUnit.SECONDS.between(LocalDateTime.now(), endOfDay);
	}

	public static Date getTodayStartDate() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}

	public static Date getTodayEndDate() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		return c.getTime();
	}

	public static String getTodayStartTime() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return toYYYY_MM_DD_HH_MM_SS(c.getTime());
	}

	public static String getTodayEndTime() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		return toYYYY_MM_DD_HH_MM_SS(c.getTime());
	}

	/**
	 * 获取时间对应的统计维度所在
	 * 00:00 - 00:15 - 00:30 ---- 23:45
	 * @param date
	 * @return
	 */
	public static String getDateDimHHMM(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		int hh = c.get(Calendar.HOUR_OF_DAY);
		int mm = c.get(Calendar.MINUTE);

		String hhString = "";
		if (hh < 10) {
			hhString = "0" + hh;
		} else {
			hhString = hh + "";
		}
		String mmString = "";
		if (mm < 15) {
			mmString = "00";
		} else  if (mm < 30) {
			mmString = "15";
		} else if (mm < 45) {
			mmString = "30";
		} else {
			mmString = "45";
		}
		return hhString + ":" + mmString;
	}

	public static String getDateDimHHMMSS() {
		Calendar c = Calendar.getInstance();
		int ss = c.get(Calendar.SECOND);
		String ssString = "";
		if (ss < 5) {
			ssString = "00";
		} else if (ss < 10) {
			ssString = "05";
		} else if (ss < 15) {
			ssString = "10";
		} else if (ss < 20) {
			ssString = "15";
		} else if (ss < 25) {
			ssString = "20";
		} else if (ss < 30) {
			ssString = "25";
		} else if (ss < 35) {
			ssString = "30";
		} else if (ss < 40) {
			ssString = "35";
		} else if (ss < 45) {
			ssString = "40";
		} else if (ss < 50) {
			ssString = "45";
		} else if (ss < 55) {
			ssString = "50";
		} else if (ss < 60) {
			ssString = "55";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		String time = sdf.format(c.getTime());
		return time + ssString;
	}

	public static Date getErrorRecallTime(int nowRecallTime) {
		if (0 == nowRecallTime) {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.MINUTE, 3);
			return calendar.getTime();
		} else if (1 == nowRecallTime) {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.MINUTE, 5);
			return calendar.getTime();
		} else if (2 == nowRecallTime) {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.MINUTE, 10);
			return calendar.getTime();
		} else {
			//cannot be happened
			throw new RuntimeException("nowRecallTime is not in 0, 1, 2.. nowRecallTime="+nowRecallTime);
		}
	}

	/**
	 * 获取日期相差天数， 向上取整
	 * @param begin
	 * @param end
	 * @return
	 */
	public static int getDaysGap(Date begin, Date end) {
		if (begin == null || end == null) {
			return 0;
		}
		long timeStampGap = end.getTime() - begin.getTime();
		long oneDayTimeStamps = 1000 * 60 * 60 * 24;
		int dayGap = (int)(timeStampGap/oneDayTimeStamps);
		if (timeStampGap % oneDayTimeStamps > 0) {
			return dayGap + 1;
		} else {
			return dayGap;
		}
	}

	public static boolean inSameYear(Date date1, Date date2) {
		Integer year1 = getYear(date1);
		Integer year2 = getYear(date2);
		return year1.equals(year2);
	}

	public static String turnYYYY_MM_DD_HH_MM_SS_to_YYYYMMDD(String yyyyMMddHHmmss) {
		Date date = parseYYYY_MM_DD_HH_MM_SS(yyyyMMddHHmmss);
		String yyyyMMdd = toYYYYMMDD(date);
		return yyyyMMdd;
	}

	public static String getDimTenMinute() {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
		String yyyyMMddHH = sdf.format(c.getTime());
		int minute = c.get(Calendar.MINUTE);
		String minuteStr = "";
		if (minute < 10) {
			minuteStr = "00";
		} else if (minute < 20) {
			minuteStr = "10";
		} else if (minute < 30) {
			minuteStr = "20";
		} else if (minute < 40) {
			minuteStr = "30";
		} else if (minute < 50) {
			minuteStr = "40";
		} else if (minute < 60) {
			minuteStr = "50";
		}
		return yyyyMMddHH + minuteStr;
	}

	/**
	 *  获得某日期范围内的月份List，格式为 yyyy-MM
	 */
	public static List<String> getRangeSet(String beginDate, String endDate)  {
		List<String> rangeList = new ArrayList<>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
		Date begin_date = null;
		Date end_date = null;
		try {
			begin_date = simpleDateFormat.parse(beginDate);
			end_date = simpleDateFormat.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar dd = Calendar.getInstance();
		dd.setTime(begin_date);
		while(!dd.getTime().after(end_date)){
			String str = simpleDateFormat.format(dd.getTime());
			rangeList.add(str);
			dd.add(Calendar.MONTH, 1);
		}
		return rangeList;
	}

	public static void main(String[] args) {
		System.out.println(getYear(new Date()));
		System.out.println(getNowYear());
		Date date = parseYYYYMMDDHHMMSS("20191101000000");
		Date now =   parseYYYYMMDDHHMMSS("20191201000000");
		;
		System.out.println(getDaysGap(date, now));
		System.out.println(date);
		System.out.println(now);


	}
}
