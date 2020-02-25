package task2;

public class TextPrinter extends WeekCalendar {

    public TextPrinter(String date) {
        super(date);
    }

    @Override
    public String print() {
        return formatTextOutPut();
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

}
