package task1;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class WeekCalendarTest {
    private WeekCalendar weekCalendar = new WeekCalendar();

    @Test
    public void week_calendar_print_test() {
        String excepted = "日\t一\t二\t三\t四\t五\t六\n";
        excepted += "5\t6\t7\t8\t9\t10\t11";
        assertThat(weekCalendar.print("2020-01-09"), is(excepted));
    }

    @Test
    public void form_text_output_test() {
        String excepted = "日\t一\t二\t三\t四\t五\t六\n";
        excepted += "5\t6\t7\t8\t9\t10\t11";
        String[] inputArr = new String[]{"5", "6", "7", "8", "9", "10", "11"};
        assertThat(weekCalendar.formatOutPut(inputArr), is(excepted));
    }

    @Test
    public void parse_date_to_week_dates_test() {
        String[] weekDatesResult = weekCalendar.parseToWeekDates("2020-01-09");
        String[] excepted = new String[]{"5", "6", "7", "8", "9", "10", "11"};
        assertThat(weekDatesResult, is(excepted));
    }
}
