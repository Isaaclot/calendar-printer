package task3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarUtil {
    public static String[] get_weekdays_to_print(String inputDate) {
        String[] weekDays = new String[7];
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(inputDate));
            // 当前日期是该周中的第几天
            int currentDatIndex = cal.get(Calendar.DAY_OF_WEEK);
            // 将calendar跳转到上周的最后一天，后续遍历七次 add 1
            int firstDateOfWeekIndex = cal.getFirstDayOfWeek() - currentDatIndex;
            cal.add(Calendar.DATE, firstDateOfWeekIndex - 1);
            // 遍历七次 找到每个日期
            for (int i = 0; i < weekDays.length; i++) {
                cal.add(Calendar.DATE, 1);
                weekDays[i] = new SimpleDateFormat("d").format(cal.getTime());
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("illegal arg");
        }
        return weekDays;
    }
}
