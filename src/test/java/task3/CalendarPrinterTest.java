package task3;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalendarPrinterTest {

    @Test
    public void create_text_calendar_test() {
        String exceptedText = "日\t一\t二\t三\t四\t五\t六\n";
        exceptedText += "5\t6\t7\t8\t9\t10\t11";
        CalendarPrinter calendarPrinter = new CalendarPrinter("2020-01-09");
        assertThat(calendarPrinter.create_text_calendar(), is(exceptedText));
    }

    @Test
    public void get_weekdays_to_print_test() {
        CalendarPrinter calendarPrinter = new CalendarPrinter("2020-01-09");
        String[] printDates = new String[]{"5", "6", "7", "8", "9", "10", "11"};
        assertThat(calendarPrinter.get_weekdays_to_print(), is(printDates));
    }

    @Test
    public void print_text_test() {
        CalendarPrinter calendarPrinter = new CalendarPrinter("2020-01-09");
        String exceptedText = "日\t一\t二\t三\t四\t五\t六\n";
        exceptedText += "5\t6\t7\t8\t9\t10\t11";
        assertThat(calendarPrinter.print("text"), is(exceptedText));
    }

    @Test
    public void create_html_calendar_test() {
        CalendarPrinter calendarPrinter = new CalendarPrinter("2020-01-09");
        StringBuffer sb = new StringBuffer();
        sb.append("<table>");
        sb.append("<thead>");
        sb.append("<tr><td>日</td><td>一</td><td>二</td><td>三</td><td>四</td><td>五</td><td>六</td></tr>");
        sb.append("</thead>");
        sb.append("<tbody>");
        sb.append("<tr><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td><td>10</td><td>11</td></tr>");
        sb.append("</tbody>");
        sb.append("</table>");
        assertThat(calendarPrinter.create_html_calendar(), is(sb.toString()));
    }

}
