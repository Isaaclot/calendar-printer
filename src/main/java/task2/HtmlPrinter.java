package task2;

public class HtmlPrinter extends WeekCalendarTask2 {

    public HtmlPrinter(String date) {
        super(date);
    }

    @Override
    public String print() {
        return formatHtmlOutPut();
    }

    public String formatHtmlOutPut() {
        StringBuffer sb = new StringBuffer();
        sb.append("<table>");
        formatTableHeader(sb);
        formatTableBody(super.printWeekDates, sb);
        sb.append("</table>");
        return sb.toString();
    }

    public void formatTableBody(String[] printWeekDates, StringBuffer htmlResult) {
        htmlResult.append("<tbody><tr>");
        for (int i = 0; i < printWeekDates.length; i++) {
            htmlResult.append("<td>").append(printWeekDates[i]).append("</td>");
        }
        htmlResult.append("</tr></tbody>");
    }


    public void formatTableHeader(StringBuffer htmlResult) {
        htmlResult.append("<thead>");
        htmlResult.append("<tr>");
        for (String date : chineseWeekDate) {
            htmlResult.append("<td>").append(date).append("</td>");
        }
        htmlResult.append("</tr>");
        htmlResult.append("</thead>");
    }
}
