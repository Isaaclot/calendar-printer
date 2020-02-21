package task1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class WeekCalendarTask1 {
    /**
     * 输入指定日期，以字符串形式返回输出日期【所属周】的日历
     *
     * @param inputDate 输入日期
     * @return {@link String} 返回的周字符串
     * @since 2020/2/21 9:10 PM
     */
    public String print(String inputDate) {
        String[] weekDateArr = parseToWeekDates(inputDate);
        return formatOutPut(weekDateArr);
    }

    public String formatOutPut(String[] weekDateArr) {
        StringBuffer sb = new StringBuffer();
        sb.append("日\t");
        sb.append("一\t");
        sb.append("二\t");
        sb.append("三\t");
        sb.append("四\t");
        sb.append("五\t");
        sb.append("六\n");
        for (int i = 0; i < weekDateArr.length; i++) {
            sb.append(weekDateArr[i]);
            if (i != weekDateArr.length - 1) {
                sb.append("\t");
            }
        }
        return sb.toString();
    }

    public String[] parseToWeekDates(String inputDate) {
        String[] weekDates = new String[7];
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
