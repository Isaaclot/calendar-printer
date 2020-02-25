package task2;

public class HtmlPrinter extends WeekCalendar {

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
        sb.append(formatTableHeader());
        sb.append(formatTableBody(super.printWeekDates));
        sb.append("</table>");
        return sb.toString();
    }

    public StringBuffer formatTableBody(String[] printWeekDates) {
        StringBuffer htmlResult = new StringBuffer();
        htmlResult.append("<tbody><tr>");
        for (int i = 0; i < printWeekDates.length; i++) {
            htmlResult.append("<td>").append(printWeekDates[i]).append("</td>");
        }
        htmlResult.append("</tr></tbody>");
        return htmlResult;
    }


    public StringBuffer formatTableHeader() {
        StringBuffer htmlResult = new StringBuffer();
        htmlResult.append("<thead>");
        htmlResult.append("<tr>");
        for (String date : chineseWeekDate) {
            htmlResult.append("<td>").append(date).append("</td>");
        }
        htmlResult.append("</tr>");
        htmlResult.append("</thead>");
        return htmlResult;
    }
}
