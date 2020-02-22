package task2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class WeekCalendarTask2 {

    public String date;

    private String[] chineseWeekDate = new String[]{"日", "一", "二", "三", "四", "五", "六"};

    private String[] printWeekDates;

    public WeekCalendarTask2(String date) {
        this.date = date;
        this.printWeekDates = parseToWeekDates(date);
    }


    public String formatTextOutPut() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chineseWeekDate.length; i++) {
            sb.append(chineseWeekDate[i]);
            if (i != printWeekDates.length - 1) {
                sb.append("\t");
            }
        }
        sb.append("\n");
        for (int i = 0; i < printWeekDates.length; i++) {
            sb.append(printWeekDates[i]);
            if (i != printWeekDates.length - 1) {
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

    public String formatHtmlOutPut() {
        StringBuffer sb = new StringBuffer();
        sb.append("<table>");
        formatTableHeader(sb);
        formatTableBody(this.printWeekDates, sb);
        sb.append("</table>");
        return sb.toString();
    }

    private void formatTableBody(String[] printWeekDates, StringBuffer htmlResult) {
        htmlResult.append("<tbody><tr>");
        for (int i = 0; i < printWeekDates.length; i++) {
            htmlResult.append("<td>").append(printWeekDates[i]).append("</td>");
        }
        htmlResult.append("</tr></tbody>");

    }

    private void formatTableHeader(StringBuffer htmlResult) {
        htmlResult.append("<thead>");
        htmlResult.append("<tr><td>日</td><td>一</td><td>二</td><td>三</td><td>四</td><td>五</td><td>六</td></tr>");
        htmlResult.append("</thead>");
    }
}
