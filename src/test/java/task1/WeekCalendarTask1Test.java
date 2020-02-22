package task1;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * 耗时：30min
 * 练习1体会
 * 1. 本次以实现功能为主，没有考虑任何的设计原则, 写完之后自己从代码设计原则的角度去思考自己写出来的代码，
 * 自觉所拆分的三个方法，符合一个方法只做一件事的原则，暂时没有想到如何优化
 * 2. 卡时间比较多的地方是在写根据日期，找出日期所在周的所有日期上，去查看了一下calendar的api，并且debug了几分钟
 * 3. 任务一本来打算是用tdd的方式进行练习，由于事前没有进行任务分解，
 * 只写了两个测试，一个是目标功能函数的测试，另一个是获取周日期函数的测试。组装输出数据的函数是后面加的
 */
public class WeekCalendarTask1Test {

    @Test
    public void week_calendar_print_test() {
        String excepted = "日\t一\t二\t三\t四\t五\t六\n";
        excepted += "5\t6\t7\t8\t9\t10\t11";
        assertThat(new WeekCalendarTask1("2020-01-09").formatTextOutPut(), is(excepted));
    }

    @Test
    public void form_text_output_test() {
        String excepted = "日\t一\t二\t三\t四\t五\t六\n";
        excepted += "5\t6\t7\t8\t9\t10\t11";
        assertThat(new WeekCalendarTask1("2020-01-09").formatTextOutPut(), is(excepted));
    }

    @Test
    public void parse_date_to_week_dates_test() {
        String[] weekDatesResult = new WeekCalendarTask1("2020-01-09").parseToWeekDates("2020-01-09");
        String[] excepted = new String[]{"5", "6", "7", "8", "9", "10", "11"};
        assertThat(weekDatesResult, is(excepted));
    }
}
