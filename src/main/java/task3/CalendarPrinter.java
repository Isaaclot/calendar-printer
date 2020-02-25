package task3;

public class CalendarPrinter {

    public static final String TEXT = "text";
    public static final String HTML = "html";
    public String inputDate;

    private int Print_Week_Date_Length = 7;

    public String[] printDates = new String[Print_Week_Date_Length];

    public String[] chineseWeekDays = new String[]{"日", "一", "二", "三", "四", "五", "六"};

    public CalendarPrinter(String date) {
        this.inputDate = date;
        get_weekdays_to_print();
    }

    public String create_text_calendar() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chineseWeekDays.length; i++) {
            stringBuilder.append(chineseWeekDays[i]);
            if (i != chineseWeekDays.length - 1) {
                stringBuilder.append("\t");
            } else {
                stringBuilder.append("\n");
            }
        }
        for (int i = 0; i < printDates.length; i++) {
            stringBuilder.append(printDates[i]);
            if (i != chineseWeekDays.length - 1) {
                stringBuilder.append("\t");
            }
        }
        return stringBuilder.toString();
    }

    public String[] get_weekdays_to_print() {
        printDates = CalendarUtil.get_weekdays_to_print(inputDate);
        return printDates;
    }

    public String print(String text) {
        if (TEXT.equals(text)) {
            return create_text_calendar();
        } else if (HTML.equals(text)) {
            return create_html_calendar();
        }
        return null;
    }

    public String create_html_calendar() {
        StringBuilder sb = new StringBuilder();
        sb.append("<table>").
                append("<thead>").
                append(generateTableTrInner(chineseWeekDays)).
                append("</thead>").
                append("<tbody>").
                append(generateTableTrInner(printDates)).
                append("</tbody>").
                append("</table>");
        return sb.toString();
    }

    public StringBuilder generateTableTrInner(String[] chineseWeekDays) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<tr>");
        for (String chineseWeekDay : chineseWeekDays) {
            stringBuilder.append("<td>").append(chineseWeekDay).append("</td>");
        }
        stringBuilder.append("</tr>");
        return stringBuilder;
    }
}
