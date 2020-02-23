package task2;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WeekCalendarTask2Test {

    @Test
    public void week_calendar_print_test() {
        String excepted = "日\t一\t二\t三\t四\t五\t六\n";
        excepted += "5\t6\t7\t8\t9\t10\t11";
        assertThat(new TextPrinter("2020-01-09").formatTextOutPut(), is(excepted));
    }

    @Test
    public void form_text_output_test() {
        String excepted = "日\t一\t二\t三\t四\t五\t六\n";
        excepted += "5\t6\t7\t8\t9\t10\t11";
        assertThat(new TextPrinter("2020-01-09").formatTextOutPut(), is(excepted));
    }

    @Test
    public void form_html_output_test() {
        StringBuffer sb = new StringBuffer();
        sb.append("<table>");
        sb.append("<thead>");
        sb.append("<tr><td>日</td><td>一</td><td>二</td><td>三</td><td>四</td><td>五</td><td>六</td></tr>");
        sb.append("</thead>");
        sb.append("<tbody>");
        sb.append("<tr><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td><td>10</td><td>11</td></tr>");
        sb.append("</tbody>");
        sb.append("</table>");
        String excepted = sb.toString();
        assertThat(new HtmlPrinter("2020-01-09").formatHtmlOutPut(), is(excepted));
    }

    @Test
    public void parse_date_to_week_dates_test() {
        String[] weekDatesResult = new TextPrinter("2020-01-09").parseToWeekDates("2020-01-09");
        String[] excepted = new String[]{"5", "6", "7", "8", "9", "10", "11"};
        assertThat(weekDatesResult, is(excepted));
    }

    @Test
    public void html_print_test(){
        StringBuffer sb = new StringBuffer();
        sb.append("<table>");
        sb.append("<thead>");
        sb.append("<tr><td>日</td><td>一</td><td>二</td><td>三</td><td>四</td><td>五</td><td>六</td></tr>");
        sb.append("</thead>");
        sb.append("<tbody>");
        sb.append("<tr><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td><td>10</td><td>11</td></tr>");
        sb.append("</tbody>");
        sb.append("</table>");
        String excepted = sb.toString();
        assertThat(new HtmlPrinter("2020-01-09").print(), is(excepted));
    }

    @Test
    public void text_print_text() {
        String excepted = "日\t一\t二\t三\t四\t五\t六\n";
        excepted += "5\t6\t7\t8\t9\t10\t11";
        assertThat(new TextPrinter("2020-01-09").print(), is(excepted));
    }
}
