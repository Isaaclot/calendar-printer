package task2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public abstract class WeekCalendar {

    public static final int Print_Week_Date_Length = 7;

    public String date;

    public String[] printWeekDates;

    public String[] chineseWeekDate = new String[]{"日", "一", "二", "三", "四", "五", "六"};

    public WeekCalendar(String date) {
        this.date = date;
        this.printWeekDates = parseToWeekDates(date);
    }

    public abstract String print();

    public String[] parseToWeekDates(String inputDate) {
        String[] weekDates = new String[Print_Week_Date_Length];
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(inputDate));
            // 当前日期是该周中的第几天
            int currentDatIndex = cal.get(Calendar.DAY_OF_WEEK);
            // 将calendar跳转到上周的最后一天，后续遍历七次 add 1
            int firstDateOfWeekIndex = cal.getFirstDayOfWeek() - currentDatIndex;
            cal.add(Calendar.DATE, firstDateOfWeekIndex - 1);
            // 遍历七次 找到每个日期
            for (int i = 0; i < weekDates.length; i++) {
                cal.add(Calendar.DATE, 1);
                weekDates[i] = new SimpleDateFormat("d").format(cal.getTime());
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("illegal arg");
        }
        return weekDates;
    }

}
